package com.example.base.设计模式.拦截器;

public class InterceptorTest {

    public static void main(String[] args) {

        TestTemplate testTemplate = new TestTemplate();
        String execute = testTemplate.execute();
        System.out.println(execute);
    }
}
