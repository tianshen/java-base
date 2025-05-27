package com.example.base.数据结构和算法.leetcode.限流算法;

/**
 * LeakyBucket 类表示一个漏桶,
 * 包含了桶的容量和漏桶出水速率等参数，
 * 以及当前桶中的水量和上次漏水时间戳等状态。
 */
public class LeakyBucket {
    // 桶的容量
    private final long capacity;
    // 漏桶出水速率
    private final long rate;
    // 当前桶中的水量
    private long water;
    // 上次漏水时间戳
    private long lastLeakTimestamp;

    public LeakyBucket(long capacity, long rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.water = 0;
        this.lastLeakTimestamp = System.currentTimeMillis();
    }

    /**
     * tryConsume() 方法用于尝试向桶中放入一定量的水，如果桶中还有足够的空间，则返回 true，否则返回 false。
     * @param waterRequested
     * @return
     */
    public synchronized boolean tryConsume(long waterRequested) {
        // 计算当前漏桶中的水剩余多少 重置漏桶中的水以及上次漏水的时间
        leak();
        // 如果漏桶中的水 + 这次流出的水 <= 容量
        if (water + waterRequested <= capacity) {
            water += waterRequested;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 。leak() 方法用于漏水，根据当前时间和上次漏水时间戳计算出应该漏出的水量，然后更新桶中的水量和漏水时间戳等状态。
     */
    private void leak() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastLeakTimestamp;
        // 这个时间段内有没有水漏出去
        long leakedWater = elapsedTime * rate / 1000;
        // 如果漏出去的水大于0
        if (leakedWater > 0) {
            // 漏桶中的水减去这个时间段内漏掉的水量，就是剩余的漏桶中的水
            water = Math.max(0, water - leakedWater);
            // 上一次漏水的时间
            lastLeakTimestamp = now;
        }
    }
}