package com.example.base.设计模式.责任链模式.节点传递方式;

public class Test {

    public static void main(String[] args) {


        Handler3 handler3 = new Handler3();
        Handler2 handler2 = new Handler2();
        handler2.setNextHandler(handler3);
        Handler1 handler1 = new Handler1();
        handler1.setNextHandler(handler2);

        handler1.process("sdsfs");

    }
}
