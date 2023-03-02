package com.example.base.设计模式.七大设计原则.接口隔离原则.positice;

public class Bird implements Eatable, Flyable{
    @Override
    public void eat() {
        System.out.println("鸟吃虫");
    }

    @Override
    public void fly() {
        System.out.println("鸟飞");
    }
}
