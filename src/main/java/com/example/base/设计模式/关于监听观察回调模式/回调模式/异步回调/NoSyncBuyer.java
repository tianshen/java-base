package com.example.base.设计模式.关于监听观察回调模式.回调模式.异步回调;

import java.util.Random;


public class NoSyncBuyer implements OrderResult {

    private Store store;

    private String buyerName;

    private String goodsName;

    public Store getStore() {
        return store;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getGoodsName() {
        return goodsName;
    }


    public NoSyncBuyer(Store store, String buyerName, String goodsName) {
        this.store = store;
        this.buyerName = buyerName;
        this.goodsName = goodsName;
    }

    /*调用从商店返回订购物品的信息*/
    public String orderGoods() {
        String goodsState = "--";
        MyRunnable mr = new MyRunnable();
        Thread thread = new Thread(mr);
        thread.start();
        System.out.println(goodsState);
        myFeeling();// 测试同步还是异步, 同步需要等待, 异步无需等待
        return goodsState;
    }

    public void myFeeling() {
        String[] s = {"有点小激动", "很期待!", "希望是个好货!"};
        Random random = new Random();
        int temp = random.nextInt(3);
        System.out.println("我是" + this.getBuyerName() + ", 我现在的感觉: " + s[temp]);
    }


    @Override
    public String getOrderResult(String state) {
        return "在" + this.getStore().getName() + "商店订购的" + this.getGoodsName() + "玩具, 目前的预订状态是: " + state;
    }

    private class MyRunnable implements Runnable{

        public String getResult() {
            return result;
        }

        private String result;

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
                result = store.returnOrderGoodsInfo(NoSyncBuyer.this);// 匿名函数的时候, 无法return 返回值
                System.out.println(result);
            } catch (InterruptedException e) {
                System.out.println("出大事了, 异步回调有问题了" + e.getMessage());
            }
        }
    }
}
