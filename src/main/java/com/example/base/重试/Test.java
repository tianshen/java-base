package com.example.base.重试;

import com.github.rholder.retry.*;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());

        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                // 异常判断
                .retryIfException()
                // 返回结果判断
                .retryIfResult(aBoolean -> Objects.equals(aBoolean, false))
                //
                // .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(2, TimeUnit.SECONDS))
                .withWaitStrategy(WaitStrategies.fixedWait(3, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))
                .withBlockStrategy(BlockStrategies.threadSleepStrategy())
                .withRetryListener(new RetryListener01())
                .build();
        try {
            retryer.call(() -> {
                System.out.println("你好");
                return false;
            });
        } catch (Exception e) {
            // 抛出异常 捕获异常
            System.out.println("exception:" + e);
        }

    }

}
