package com.example.base.设计模式.责任链模式.节点传递方式;

public class Handler1 extends AbstractHandler {
    @Override
    public void doProcess(String msg) {
        System.out.println("[Handler1] process " + msg);
    }
}