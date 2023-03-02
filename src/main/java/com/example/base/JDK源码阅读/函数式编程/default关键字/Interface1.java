package com.example.base.JDK源码阅读.函数式编程.default关键字;

public interface Interface1{
    default void helloWorld() {
        System.out.println("hi i'm from Interface1");
    }
}