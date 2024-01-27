package com.example.base.设计模式.责任链模式.节点传递方式;

public class Handler3 extends AbstractHandler {
    @Override
    protected void doProcess(String msg) {
        System.out.println("[Handler3] process " + msg);
    }
}