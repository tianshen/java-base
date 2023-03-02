package com.example.base.设计模式.关于监听观察回调模式.监听器模式.基础示例;

public class AddEventListenerHandler implements EventListenerHandler{

    @Override
    public void handler(EventInfo eventInfo) {
        if (eventInfo == null) {
            return;
        }

        if (eventInfo.getEventType().equals("add")) {
            System.out.println("添加购物车事件。。。");
        }
    }
}
