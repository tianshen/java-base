package com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.listener;


import com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.event.ApplicationEvnt;

public interface ApplicationListener< E extends ApplicationEvnt> {

    void onEvnt(E e);
}
