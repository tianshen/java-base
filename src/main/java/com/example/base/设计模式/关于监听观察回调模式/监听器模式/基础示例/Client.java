package com.example.base.设计模式.关于监听观察回调模式.监听器模式.基础示例;

public class Client {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        EventListenerHandler addEventListenerHandler = new AddEventListenerHandler();
        eventSource.registryEventListenerHandler(addEventListenerHandler);
        //eventSource.removeEventListenerHandler(addEventListenerHandler);
        eventSource.addCar();
        eventSource.addCar();
    }
}
