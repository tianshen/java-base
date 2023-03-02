package com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.manage;


import com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.event.ApplicationEvnt;
import com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.listener.ApplicationListener;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

//事件管理器
public class ListenerManage {

    //保存所有的监听器
    static List<ApplicationListener<?>> list = new ArrayList<>();

    //添加监听器  //如果要做得优雅一点 可以考虑扫描项目
    //定义注解
    public static void addListener(ApplicationListener listener) {
        list.add(listener);
    }

    //判断一下有哪些人对这个事件感兴趣
    public static void pushEvent(ApplicationEvnt evnt) {
        for (ApplicationListener applicationListener : list) {
            //拿泛型
            Class tClass = (Class) ((ParameterizedType) applicationListener.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
            //判断一下泛型
//            tClass.isAssignableFrom()
            if (tClass.equals(evnt.getClass())) {
                applicationListener.onEvnt(evnt);
            }
        }
    }

}
