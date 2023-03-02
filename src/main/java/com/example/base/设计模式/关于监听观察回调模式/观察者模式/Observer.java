package com.example.base.设计模式.关于监听观察回调模式.观察者模式;

/**
 * @author jiwei.xue
 * @date 2020/10/28 11:27
 */
public interface Observer {

    /**
     * 收到通知之后执行的代码块
     * @param message
     */
    void process(String message);
}
