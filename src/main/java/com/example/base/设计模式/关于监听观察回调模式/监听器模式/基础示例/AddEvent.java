package com.example.base.设计模式.关于监听观察回调模式.监听器模式.基础示例;

import java.util.EventObject;

public class AddEvent extends EventObject implements EventInfo{

    private final String eventType = "add";

    public AddEvent(Object source) {
        super(source);
    }

    @Override
    public String getEventType() {
        return eventType;
    }

    @Override
    public Object getEventSource() {
        return getSource();
    }
}
