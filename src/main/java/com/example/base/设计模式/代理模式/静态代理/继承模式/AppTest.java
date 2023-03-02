package com.example.base.设计模式.代理模式.静态代理.继承模式;

public class AppTest {

    public static void main(String[] args) {

        Calculator calProxy = new CalProxy();
        calProxy.add(1, 2);

    }
}
