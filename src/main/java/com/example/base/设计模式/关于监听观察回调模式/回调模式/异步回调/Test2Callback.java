package com.example.base.设计模式.关于监听观察回调模式.回调模式.异步回调;

public class Test2Callback {

    public static void main(String[] args) {
        Store lawson = new Store("沙中路罗森便利店");
        NoSyncBuyer noSyncBuyer = new NoSyncBuyer(lawson, "cherry", "变形金刚");
        System.out.println(noSyncBuyer.orderGoods());
    }
}
