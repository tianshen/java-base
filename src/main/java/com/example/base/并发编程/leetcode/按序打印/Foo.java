package com.example.base.并发编程.leetcode.按序打印;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiwei.xue
 * @date 2021/1/7 15:24
 */
public class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) {
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) {
        // 轮询  忙等   或者使用锁
        while (firstJobDone.get() != 1) {

        }
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) {
        while (secondJobDone.get() != 1) {

        }
        printThird.run();
    }
}
