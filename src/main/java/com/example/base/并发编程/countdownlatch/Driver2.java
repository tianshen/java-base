package com.example.base.并发编程.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class Driver2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(10);
        Executor e = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; ++i) {
            e.execute(new WorkerRunnable(doneSignal, i));
        }

        doneSignal.await();           // wait for all to finish
        System.err.println("work");
    }
}


