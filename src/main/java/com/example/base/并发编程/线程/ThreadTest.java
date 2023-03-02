package com.example.base.并发编程.线程;

import lombok.Synchronized;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) {

        // 线程的生命周期
        // 调用start方法和调用run方法的区别是什么   start方法回调用我们的操作中创建线程的方法 但是run方法不会调用
        // 调用start方法 -- 调用start0方法

        // 协程 -- 用户级别的线程 -- 只在用户态中生成，减少用户态和内核态的切换 -- 减少上下文的切换

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 锁实例对象
                synchronized (this) {
                    System.out.println("test");
                }
            }
        });
        thread.start();



        new FutureTask(() -> null);


    }
}
