package com.example.base.设计模式.关于监听观察回调模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiwei.xue
 * @date 2020/10/28 11:34
 */
public class ConcreteSubject implements Subject{

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    @Override
    public void deleteObserver(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notice(String message) {
        for (Observer observer : observerList) {
            observer.process(message);
        }
    }
}
