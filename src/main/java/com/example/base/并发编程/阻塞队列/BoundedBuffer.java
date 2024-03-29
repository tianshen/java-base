package com.example.base.并发编程.阻塞队列;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {

    final ReentrantLock lock = new ReentrantLock();
    final AbstractQueuedSynchronizer.ConditionObject notFull = (AbstractQueuedSynchronizer.ConditionObject) lock.newCondition();
    final AbstractQueuedSynchronizer.ConditionObject notEmpty = (AbstractQueuedSynchronizer.ConditionObject) lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            // 当数组满了
            while (count == items.length) {
                // 释放锁，等待
                notFull.await();
            }
            // 放入数据
            items[putptr] = x;
            // 如果到最后一个位置了,下标从头开始,防止下标越界
            if (++putptr == items.length) {
                // 从头开始
                putptr = 0;
            }
            // 对 count ++ 加加
            ++count;
            // 通知 take 线程,可以取数据了,不必继续阻塞
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            // 如果数组没有数据,则等待
            while (count == 0) {
                notEmpty.await();
            }
            // 取数据
            Object x = items[takeptr];
            // 如果到数组尽头了,就从头开始
            if (++takeptr == items.length) {
                // 从头开始
                takeptr = 0;
            }
            // 将数量减1
            --count;
            // 通知阻塞的 put 线程可以装填数据了
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}