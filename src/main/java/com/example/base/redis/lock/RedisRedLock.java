package com.example.base.redis.lock;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

@RequiredArgsConstructor
public class RedisRedLock implements RedLock {

    private final JedisPool jedisPool;
    private final String uuid;

    private static final String WATCH_DOG_TIMEOUT_STRING = "30000";
    private static final long WATCH_DOG_TASK_DURATION = 10000L;
    private static final String CHANNEL_PREFIX = "__red__lock:";
    private static final String UNLOCK_STATUS_STRING = "0";

    private static final String LOCK_LUA = "if (redis.call('exists', KEYS[1]) == 0) then\n" +
            "    redis.call('hset', KEYS[1], ARGV[2], 1);\n" +
            "    redis.call('pexpire', KEYS[1], ARGV[1]);\n" +
            "    return nil;\n" +
            "end;\n" +
            "if (redis.call('hexists', KEYS[1], ARGV[2]) == 1) then\n" +
            "    redis.call('hincrby', KEYS[1], ARGV[2], 1);\n" +
            "    redis.call('pexpire', KEYS[1], ARGV[1]);\n" +
            "    return nil;\n" +
            "end;\n" +
            "return redis.call('pttl', KEYS[1]);";

    private static final String UNLOCK_LUA = "if (redis.call('hexists', KEYS[1], ARGV[3]) == 0) then\n" +
            "    return nil;\n" +
            "end;\n" +
            "local counter = redis.call('hincrby', KEYS[1], ARGV[3], -1);\n" +
            "if (counter > 0) then\n" +
            "    redis.call('pexpire', KEYS[1], ARGV[2]);\n" +
            "    return 0;\n" +
            "else\n" +
            "    redis.call('del', KEYS[1]);\n" +
            "    redis.call('publish', KEYS[2], ARGV[1]);\n" +
            "    return 1;\n" +
            "end;";

    private static final String RENEW_LUA = "if (redis.call('hexists', KEYS[1], ARGV[2]) == 1) then " +
            "redis.call('pexpire', KEYS[1], ARGV[1]); " +
            "return 1; " +
            "end; " +
            "return 0;";

    private static final ExecutorService SUB_PUB_POOL = Executors.newCachedThreadPool();
    private static final ScheduledExecutorService WATCH_DOG_POOL = new ScheduledThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors() * 2
    );

    private static class ThreadEntry {

        private final Map<Long, Integer> threadCounter = Maps.newConcurrentMap();

        private volatile WatchDogTask watchDogTask;

        public synchronized void addThreadId(long threadId) {
            Integer counter = threadCounter.get(threadId);
            if (counter == null) {
                counter = 1;
            } else {
                counter++;
            }
            threadCounter.put(threadId, counter);
        }

        public synchronized boolean hasNoThreads() {
            return threadCounter.isEmpty();
        }

        public synchronized Long getFirstThreadId() {
            if (threadCounter.isEmpty()) {
                return null;
            }
            return threadCounter.keySet().iterator().next();
        }

        public synchronized void removeThreadId(long threadId) {
            Integer counter = threadCounter.get(threadId);
            if (counter == null) {
                return;
            }
            counter--;
            if (counter == 0) {
                threadCounter.remove(threadId);
            } else {
                threadCounter.put(threadId, counter);
            }
        }

        public void setWatchDogTask(WatchDogTask watchDogTask) {
            this.watchDogTask = watchDogTask;
        }

        public WatchDogTask getWatchDogTask() {
            return watchDogTask;
        }
    }

    @Getter
    private static class SubPubEntry {

        private final String key;
        private final Semaphore latch;
        private final SubscribeListener subscribeListener;

        public SubPubEntry(String key) {
            this.key = key;
            this.latch = new Semaphore(0);
            this.subscribeListener = new SubscribeListener(key, latch);
        }
    }

    private static final ConcurrentMap<String, ThreadEntry> THREAD_ENTRY_MAP = Maps.newConcurrentMap();

    @Override
    public void lock(String resource) throws InterruptedException {
        long threadId = Thread.currentThread().getId();
        String lockName = uuid + ":" + threadId;
        String entryName = uuid + ":" + resource;
        // 获取锁
        Long ttl = acquire(resource, lockName, threadId, entryName);
        // 加锁成功直接返回    ttl == null
        if (Objects.isNull(ttl)) {
            return;
        }
        // 没有获取到锁   订阅解锁的频道
        SubPubEntry subPubEntry = subscribeAsync(resource);
        try {
            for (; ; ) {
                // 再尝试去加锁
                ttl = acquire(resource, lockName, threadId, entryName);
                // 加锁成功直接返回
                if (Objects.isNull(ttl)) {
                    return;
                }
                if (ttl > 0L) {
                    subPubEntry.getLatch().tryAcquire(ttl, TimeUnit.MILLISECONDS);
                }
            }
        } finally {
            unsubscribeSync(subPubEntry);
        }
    }

    private Long acquire(String key, String lockName, long threadId, String entryName) {
        // 执行lua脚本获取锁
        Object result = execute0(jedis -> jedis.eval(LOCK_LUA, Lists.newArrayList(key), Lists.newArrayList(WATCH_DOG_TIMEOUT_STRING, lockName)));
        // 如果result ！= null 说明已经有线程获取到锁了
        if (Objects.nonNull(result)) {
            return Long.parseLong(String.valueOf(result));
        }
        // result == null,说明抢到锁了，抢到锁之后启动看门狗。 这就是守护线程吗？
        // 启动看门狗
        ThreadEntry entry = new ThreadEntry();
        ThreadEntry oldEntry = THREAD_ENTRY_MAP.putIfAbsent(entryName, entry);
        if (oldEntry != null) {
            oldEntry.addThreadId(threadId);
        } else {
            // 添加到map中
            entry.addThreadId(threadId);
            Runnable renewAction = () -> executeWithoutResult(jedis -> jedis.eval(RENEW_LUA, Lists.newArrayList(key),
                    Lists.newArrayList(WATCH_DOG_TIMEOUT_STRING, lockName)));
            WatchDogTask watchDogTask = new WatchDogTask(new AtomicReference<>(renewAction));
            entry.setWatchDogTask(watchDogTask);
            WATCH_DOG_POOL.scheduleWithFixedDelay(watchDogTask, 0, WATCH_DOG_TASK_DURATION, TimeUnit.MILLISECONDS);
        }
        return null;
    }

    private SubPubEntry subscribeAsync(String key) {
        SubPubEntry subPubEntry = new SubPubEntry(key);
        SUB_PUB_POOL.submit(() -> {
            SubscribeListener subscribeListener = subPubEntry.getSubscribeListener();
            executeWithoutResult(jedis -> jedis.subscribe(subscribeListener, subscribeListener.getChannelName()));
            return null;
        });
        return subPubEntry;
    }

    private void unsubscribeSync(SubPubEntry subPubEntry) {
        SubscribeListener subscribeListener = subPubEntry.getSubscribeListener();
        subscribeListener.unsubscribe(subscribeListener.getChannelName());
    }

    @Override
    public void unlock(String resource) {
        long threadId = Thread.currentThread().getId();
        String entryName = uuid + ":" + resource;
        String lockName = uuid + ":" + threadId;
        String channelName = CHANNEL_PREFIX + resource;
        Object result = execute0(jedis -> jedis.eval(UNLOCK_LUA, Lists.newArrayList(resource, channelName),
                Lists.newArrayList(UNLOCK_STATUS_STRING, WATCH_DOG_TIMEOUT_STRING, lockName)));
        ThreadEntry threadEntry = THREAD_ENTRY_MAP.get(entryName);
        if (Objects.nonNull(threadEntry)) {
            threadEntry.removeThreadId(threadId);
            if (threadEntry.hasNoThreads() && Objects.nonNull(threadEntry.getWatchDogTask())) {
                threadEntry.getWatchDogTask().cancel();
            }
        }
        if (Objects.isNull(result)) {
            throw new IllegalMonitorStateException();
        }
    }

    private static class SubscribeListener extends JedisPubSub {

        @Getter
        private final String key;
        @Getter
        private final String channelName;
        @Getter
        private final Semaphore latch;

        public SubscribeListener(String key, Semaphore latch) {
            this.key = key;
            this.channelName = CHANNEL_PREFIX + key;
            this.latch = latch;
        }

        @Override
        public void onMessage(String channel, String message) {
            if (Objects.equals(channelName, channel) && Objects.equals(UNLOCK_STATUS_STRING, message)) {
                latch.release();
            }
        }
    }

    @RequiredArgsConstructor
    private static class WatchDogTask implements Runnable {

        private final AtomicBoolean running = new AtomicBoolean(true);
        private final AtomicReference<Runnable> actionReference;

        @Override
        public void run() {
            if (running.get() && Objects.nonNull(actionReference.get())) {
                actionReference.get().run();
            } else {
                throw new WatchDogTaskStopException("watch dog cancel");
            }
        }

        public void cancel() {
            actionReference.set(null);
            running.set(false);
        }
    }

    private <T> T execute0(Function<Jedis, T> function) {
        try (Jedis jedis = jedisPool.getResource()) {
            return function.apply(jedis);
        }
    }

    interface Action {

        void apply(Jedis jedis);
    }

    private void executeWithoutResult(Action action) {
        try (Jedis jedis = jedisPool.getResource()) {
            action.apply(jedis);
        }
    }

    private static class WatchDogTaskStopException extends RuntimeException {

        public WatchDogTaskStopException(String watchDogCancel) {

        }

        @Override
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static void main(String[] args) throws Exception {
        String resourceName = "resource:x";
        RedLock redLock = new RedisRedLock(new JedisPool(new GenericObjectPoolConfig()), UUID.randomUUID().toString());
        Thread threadA = new Thread(() -> {
            try {
                redLock.lock(resourceName);
                process(resourceName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                redLock.unlock(resourceName);
                System.out.println(String.format("线程%s释放资源%s的锁", Thread.currentThread().getName(), resourceName));
            }
        }, "threadA");
        Thread threadB = new Thread(() -> {
            try {
                redLock.lock(resourceName);
                process(resourceName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                redLock.unlock(resourceName);
                System.out.println(String.format("线程%s释放资源%s的锁", Thread.currentThread().getName(), resourceName));
            }
        }, "threadB");
        threadA.start();
        threadB.start();
        Thread.sleep(Long.MAX_VALUE);
    }

    private static void process(String resourceName) {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程%s获取到资源%s的锁", threadName, resourceName));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }
    }
}