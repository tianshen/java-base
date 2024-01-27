package com.example.base.设计模式.责任链模式.sentinel;

public interface ProcessorSolt<T> {

    /**
     * 前置处理方法
     */
    void process(T param);

    /**
     * 触发下一个
     * @param param
     */
    void fireProcess(T param);
}