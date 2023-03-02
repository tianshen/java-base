package com.example.base.设计模式.关于监听观察回调模式.观察者模式;

/**
 * @author jiwei.xue
 * @date 2020/10/28 11:27
 */
public interface Subject {

    /**
     * 添加观察者
     * @param observer
     */
    void addObserver(Observer observer);

    /**
     * 删除观察者
     */
    void deleteObserver(Observer observer);

    /**
     * 通知观察者
     * @param message
     */
    void notice(String message);
}
