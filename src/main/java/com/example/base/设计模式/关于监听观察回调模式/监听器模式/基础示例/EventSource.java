package com.example.base.设计模式.关于监听观察回调模式.监听器模式.基础示例;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class EventSource {

    private Collection<EventListenerHandler> eventListenerHandlers = null;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void registryEventListenerHandler(EventListenerHandler eventListenerHandler) {
        if (eventListenerHandlers == null) {
            eventListenerHandlers = new HashSet<EventListenerHandler>();
            eventListenerHandlers.add(eventListenerHandler);
        }
    }

    public void removeEventListenerHandler(EventListenerHandler eventListenerHandler) {
        if (eventListenerHandlers != null) {
            eventListenerHandlers.remove(eventListenerHandler);
        }
    }

    public void addCar() {
        ++count;
        if (eventListenerHandlers != null) {
            EventInfo eventInfo = new AddEvent(this);
            notifies(eventInfo);
        }
        System.out.println("向购物车添加商品成功...");
    }

    private void notifies(EventInfo eventInfo) {
        Iterator iterator = eventListenerHandlers.iterator();
        while (iterator.hasNext()) {
            ((EventListenerHandler) iterator.next()).handler(eventInfo);
        }
    }
}
