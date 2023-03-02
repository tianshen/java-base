package com.example.base.设计模式.关于监听观察回调模式.观察者模式;

/**
 * @author jiwei.xue
 * @date 2020/10/28 11:38
 */
public class ObserverTest {

    public static void main(String[] args) {
        //构建当前主题类
        ConcreteSubject concreteSubject = new ConcreteSubject();
        //构建当前观察者
        ConcreteObserver concreteObserver = new ConcreteObserver();
        //给主题添加观察者
        concreteSubject.addObserver(concreteObserver);
        //主题发生变更时通知观察者 （实际就是触发观察者的process方法）
        concreteSubject.notice("当前主题发生变更");

    }
}
