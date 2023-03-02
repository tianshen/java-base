package com.example.base.设计模式.代理模式.动态代理;

public class CalImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        int r = a + b;
        return r;
    }
}
