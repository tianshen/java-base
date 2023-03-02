package com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.listener;


import com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.event.BEvent;

public class BListener implements ApplicationListener<BEvent> {
    @Override
    public void onEvnt(BEvent bEvent) {
        System.out.println("监听到了B事件");
    }
}
