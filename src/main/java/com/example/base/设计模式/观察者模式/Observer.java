package com.example.base.设计模式.观察者模式;

public interface Observer<T> {

    /**
     * 更新方法
     *
     * @param t
     */
    void update(T t);
}
