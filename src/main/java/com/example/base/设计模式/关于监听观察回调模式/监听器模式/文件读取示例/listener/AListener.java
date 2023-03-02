package com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.listener;


import com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.event.AEvent;

public class AListener  implements ApplicationListener<AEvent>{
    @Override
    public void onEvnt(AEvent aEvent) {
        System.out.println("监听到了A事件");
    }
}
