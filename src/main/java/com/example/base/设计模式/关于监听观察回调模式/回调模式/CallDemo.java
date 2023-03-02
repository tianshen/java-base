package com.example.base.设计模式.关于监听观察回调模式.回调模式;

/**
 * @author jiwei.xue
 * @date 2020/10/28 12:22
 */
public class CallDemo {

    public static void main(String[] args) {


        Caller caller = new Caller();
        caller.call(() -> System.out.println("回调成功"));
    }
}
