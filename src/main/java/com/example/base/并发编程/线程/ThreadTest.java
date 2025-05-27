package com.example.base.并发编程.线程;

import lombok.Synchronized;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;

public class ThreadTest {

    public static void main(String[] args) {

        // 线程的生命周期
        // 调用start方法和调用run方法的区别是什么   start方法回调用我们的操作中创建线程的方法 但是run方法不会调用
        // 调用start方法 -- 调用start0方法

        // 协程 -- 用户级别的线程 -- 只在用户态中生成，减少用户态和内核态的切换 -- 减少上下文的切换

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // 锁实例对象
//                synchronized (this) {
//                    System.out.println("test");
//                }
//            }
//        });
//        thread.start();
//
//
//
//        new FutureTask(() -> null);

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread());
//                System.out.println("你好");
//            }
//        };
//        runnable.run();
//
//
//        System.out.println("=========================");

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println("run");
//            }
//        });
//        System.out.println(thread.getName());
//        thread.run();
//        thread.start();
////
//        A a = new A();
//        a.run();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };

        // 继承
        B b = new B();
        b.start();

        // 实现runnable
        Thread a = new Thread(new A());
        a.start();



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    System.out.println("11");
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        // System.out.println(thread.isInterrupted());


        CountDownLatch countDownLatch = new CountDownLatch(2);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
