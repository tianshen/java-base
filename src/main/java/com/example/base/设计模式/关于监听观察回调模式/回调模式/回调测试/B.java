package com.example.base.设计模式.关于监听观察回调模式.回调模式.回调测试;

public class B {

    public String process(ICallback callback) {
        return callback.callback();
    }
}
