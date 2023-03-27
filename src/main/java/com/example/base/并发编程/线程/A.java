package com.example.base.并发编程.线程;

/**
 * @author eunhye
 */
public class A implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("A");
    }
}
