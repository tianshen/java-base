package com.example.base.设计模式.关于监听观察回调模式.回调模式.同步回调;

import java.util.Random;


public class Store {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Store(String name) {
        this.name = name;
    }

    /*回调函数, 将结构传给那个我们不能直接调用的方法, 然后获取结果*/
    public String returnOrderGoodsInfo(OrderResult order) {
        String[] s = {"订购中...", "订购失败", "即将发货!", "运输途中...", "已在投递"};
        Random random = new Random();
        int temp = random.nextInt(5);
        String s1 = s[temp];
        return order.getOrderResult(s1);
    }

}
