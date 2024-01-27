package com.example.base.设计模式.责任链模式.节点传递方式;

public abstract class AbstractHandler implements Handler {
    private Handler next;

    public AbstractHandler setNextHandler(Handler next) {
        this.next = next;
        return this;
    }

    @Override
    public void process(String msg) {
        doProcess(msg);

        if (next != null) {
            next.process(msg);
        }
    }

    protected abstract void doProcess(String msg);
}