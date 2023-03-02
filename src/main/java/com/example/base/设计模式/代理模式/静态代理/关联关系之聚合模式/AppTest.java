package com.example.base.设计模式.代理模式.静态代理.关联关系之聚合模式;

public class AppTest {

    public static void main(String[] args) {

        Calculator cal = new CalImpl();
        Calculator calculator = new CalProxy(cal);
        calculator.add(1, 2);
    }
}
