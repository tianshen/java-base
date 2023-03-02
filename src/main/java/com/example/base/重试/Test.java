package com.example.base.重试;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.AttemptTimeLimiters;
import com.github.rholder.retry.RetryListener;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfException()
                .retryIfResult(aBoolean -> Objects.equals(aBoolean, false))
                // .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(10, TimeUnit.SECONDS, Executors.newCachedThreadPool()))
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))
                .build();
        try {
            retryer.call(() -> {
                System.out.println("你好");
                return false;
            });
        } catch (Exception e) {
            System.out.println("exception:" + e);
        }

    }
}
