package com.example.base.设计模式.工厂模式.简单工厂模式.negvite;

interface Food {

    void eat();
}

class Hamburger implements Food {

    @Override
    public void eat() {
        System.out.println("吃汉堡包");
    }
}


// ===============================================================

public class AppTest {

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger();
        hamburger.eat();

    }
}
