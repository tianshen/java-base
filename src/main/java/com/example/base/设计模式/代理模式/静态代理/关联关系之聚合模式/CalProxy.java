package com.example.base.设计模式.代理模式.静态代理.关联关系之聚合模式;

public class CalProxy implements Calculator {

    private Calculator calculator;

    public CalProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int a, int b) {

        //增强
        System.out.println("增强的业务逻辑");
        //主业务逻辑
        int r = calculator.add(a, b);
        System.out.println("主业务逻辑");
        return r;
    }

}
