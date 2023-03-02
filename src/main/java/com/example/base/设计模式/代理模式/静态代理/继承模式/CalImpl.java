package com.example.base.设计模式.代理模式.静态代理.继承模式;

public class CalImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        int r = a + b;
        return r;
    }
}
