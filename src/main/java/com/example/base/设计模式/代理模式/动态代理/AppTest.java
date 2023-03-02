package com.example.base.设计模式.代理模式.动态代理;

import java.lang.reflect.Proxy;

public class AppTest {

    public static void main(String[] args) {

        Calculator calculator = new CalImpl();
        ClassLoader classLoader = AppTest.class.getClassLoader();
        Calculator instance = (Calculator)Proxy.newProxyInstance(classLoader, new Class[]{Calculator.class}, new MyHandler(calculator));
        instance.add(1, 2);
    }
}
