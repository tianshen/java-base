package com.example.base.设计模式.责任链模式.统一传递方式;

public class Handler1 implements Handler {
    @Override
    public void process(String msg) {
        System.out.println("[Handler1] process " + msg);
    }
}