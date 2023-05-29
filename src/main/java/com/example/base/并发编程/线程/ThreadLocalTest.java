package com.example.base.并发编程.线程;

/**
 * @author xue
 * @date 2023/5/16 9:54
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> localInt = new ThreadLocal<>();

    public static void main(String[] args) {

        localInt.set(2);
        localInt.set(3);
        localInt.set(4);
        System.out.println(localInt.get());
        System.out.println(localInt.get());
        System.out.println(localInt.get());

    }
}
