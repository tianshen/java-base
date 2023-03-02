package com.example.base.设计模式.七大设计原则.开闭原则.positive;

/**
 * 所有的汽车需要打8折。
 * 符合开闭原则的做法： 始终保证Car的源代码不会被修改，我们可以这样做：
 * 创建一个car的子类，重写car的getPrice方法。
 */
public class AppTest {

    public static void main(String[] args) {

        Car car = new DiscountCar();
        car.setBrand("奔驰");
        car.setColor("黑色");
        car.setLouyou(true);
        car.setPrice(6666666);

        System.out.println(car.getPrice());
    }
}
