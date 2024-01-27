package com.example.base.设计模式.责任链模式.统一传递方式;

import java.util.ArrayList;
import java.util.List;

public class HandlerWrap {
    private List<Handler> handlerList = new ArrayList<>();

    public HandlerWrap() {
        handlerList.add(new Handler1());
        handlerList.add(new Handler2());
        handlerList.add(new Handler3());
    }

    public void process(String msg) {
        for (Handler handler : handlerList) {
            handler.process(msg);
        }
    }
}