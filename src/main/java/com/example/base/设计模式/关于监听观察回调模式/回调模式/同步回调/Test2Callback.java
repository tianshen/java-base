package com.example.base.设计模式.关于监听观察回调模式.回调模式.同步回调;

public class Test2Callback {

    public static void main(String[] args) {
        Store wallMart = new Store("沙中路沃尔玛");
        SyncBuyer syncBuyer = new SyncBuyer(wallMart, "小明", "超能铁扇公主");
        System.out.println(syncBuyer.orderGoods());
    }
}
