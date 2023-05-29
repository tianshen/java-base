package com.example.base.netty;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

/**
 * @author xue
 * @date 2023/5/19 20:28
 */
public class TimeTest {

    public static void main(String[] args) {

        // HashedWheelTimer hashedWheelTimer = new HashedWheelTimer();

        HashedWheelTimer timer = new HashedWheelTimer(new DefaultThreadFactory("redisson-timer"), 100, TimeUnit.MILLISECONDS, 1024, false);

        Timeout timeout = timer.newTimeout(new MyTimeTask(), 5, TimeUnit.SECONDS);
        Timeout timeout1 = timer.newTimeout(new MyTimeTask(), 10, TimeUnit.SECONDS);

    }

    public static class MyTimeTask implements TimerTask {

        @Override
        public void run(Timeout timeout) throws Exception {
            Timer timer = timeout.timer();

            // timeout.task();
            //CompletionStage<Map<String, String>> replicationFuture = CompletableFuture.completedFuture(Collections.emptyMap());
            System.out.println("111");
        }
    }
}
