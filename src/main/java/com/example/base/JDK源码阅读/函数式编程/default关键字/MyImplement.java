package com.example.base.JDK源码阅读.函数式编程.default关键字;

/**
 * 实现接口Interface1
 */
public class MyImplement implements Interface1, Interface2{
    public static void main(String[] args) {
        MyImplement myImplement = new MyImplement();
        //直接调用helloWorld()方法
        myImplement.helloWorld();
    }

    @Override
    public void helloWorld() {
        System.out.println("hi i'm from MyImplement");
    }
}