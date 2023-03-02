package com.example.base.设计模式.七大设计原则.接口隔离原则.negtive;

public class Bird implements Animal{
    @Override
    public void eat() {
        System.out.println("鸟吃虫子");
    }

    @Override
    public void swim() {
        throw new RuntimeException("You can You up");
    }

    @Override
    public void fly() {
        System.out.println("我飞....");
    }
}
