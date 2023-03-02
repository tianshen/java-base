package com.example.base.设计模式.观察者模式;

public interface Observerable<T> {

    /**
     * 注册监听者
     * @param o
     */
    void registerObserver(Observer<T> o);

    /**
     * 移除监听者
     * @param o
     */
    void removeObserver(Observer<T> o);

    /**
     * 通知监听者
     * @param t
     */
    void notifyObserver(T t);

    void sortObserver(Class annotationType);
}
