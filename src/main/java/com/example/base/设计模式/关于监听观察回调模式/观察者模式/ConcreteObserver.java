package com.example.base.设计模式.关于监听观察回调模式.观察者模式;

/**
 * @author jiwei.xue
 * @date 2020/10/28 11:32
 */
public class ConcreteObserver implements Observer{


    @Override
    public void process(String message) {
        System.out.println("收到通知---" + message);
    }
}
