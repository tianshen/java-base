package com.example.base.并发编程.leetcode.按序打印;

/**
 * @author jiwei.xue
 * @date 2021/1/7 15:32
 */
public class TestFoo {

    public static void main(String[] args) {

        Foo foo = new Foo();
        foo.first(() -> System.out.println("first"));
        foo.second(() -> System.out.println("second"));
        foo.third(() -> System.out.println("third"));
    }
}
