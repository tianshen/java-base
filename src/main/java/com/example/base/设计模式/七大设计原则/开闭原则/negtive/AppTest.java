package com.example.base.设计模式.七大设计原则.开闭原则.negtive;

/**
 * 所有的汽车需要打8折。
 * 违反开闭原则的做法： car的源代码被修改
 */
public class AppTest {

    public static void main(String[] args) {

        Car car = new Car();
        car.setBrand("奔驰");
        car.setColor("黑色");
        car.setLouyou(true);
        car.setPrice(6666666);

        System.out.println(car.getPrice());
    }
}
