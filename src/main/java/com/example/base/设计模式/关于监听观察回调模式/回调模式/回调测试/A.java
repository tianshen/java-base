package com.example.base.设计模式.关于监听观察回调模式.回调模式.回调测试;

public class A{

    private B b;

    public A (B b) {
        this.b = b;
    }

    public String a() {
        return b.process(new C());
    }

}
