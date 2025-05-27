package com.example.base.并发编程.线程池;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10000), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(() -> {
            // 执行我们的业务代码
            System.out.println("测试");

        });
        threadPoolExecutor.shutdown(); // 对应的线程池的状态 SHUTDOWN  线程被中断
        threadPoolExecutor.shutdownNow(); // 对应的线程池的状态  STOP

        threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });


    }
}
