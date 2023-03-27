package com.example.base.设计模式.关于监听观察回调模式.回调模式.回调测试;

public class Test {


    public static void main(String[] args) {

        B b = new B();
        A a = new A(b);
        System.out.println(a.a());

    }
}
