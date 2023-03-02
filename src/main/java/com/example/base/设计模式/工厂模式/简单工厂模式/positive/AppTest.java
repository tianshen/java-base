package com.example.base.设计模式.工厂模式.简单工厂模式.positive;

interface Food {

    void eat();
}

class Hamburger implements Food {

    @Override
    public void eat() {
        System.out.println("吃汉堡包");
    }
}

class RiceNoodle implements Food {

    @Override
    public void eat() {
        System.out.println("吃过桥米线");
    }
}

/**
 * 简单工厂：
 * 优点：
 *      1、把具体产品的类型，从客户端代码中，解耦出来。
 *      2、服务器端如果修改了具体产品的类名，客户端也知道。
 *      这便符合了"面向接口编程"的思想
 * 缺点：
 *      1、客户端不得不死记硬背那些常量与具体产品的映射关系，比如： 1 对应 汉堡包 2 对应 米线
 *      2、如果具体产品特别多，则简单工厂就会变得十分臃肿，比如有100个具体产品，则需要在简单工厂的switch中写出100个case。
 *      3、最重要的是 变化来了： 客户端需要扩展具体的产品的时候，势必要修改简单工厂中的代码，这样便违反了"开闭原则"。
 */
class FoodFactory {
    public static Food getFood (int n) {
        Food food = null;
        switch (n) {
            case 1:
                food = new Hamburger();
                break;
            case 2:
                food = new RiceNoodle();
        }
        return food;
    }
}


// ===============================================================

class Lp implements Food {

    @Override
    public void eat() {
        System.out.println("吃凉皮");
    }
}

public class AppTest {

    public static void main(String[] args) {

        Food food = FoodFactory.getFood(2);
        food.eat();
    }
}
