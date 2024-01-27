package com.example.base.设计模式.责任链模式.节点传递方式;

public interface Handler {
    default boolean match(String msg) {
        return true;
    }
    void process(String msg);
}