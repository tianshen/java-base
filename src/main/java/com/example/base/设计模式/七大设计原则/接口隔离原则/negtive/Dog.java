package com.example.base.设计模式.七大设计原则.接口隔离原则.negtive;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗刨");
    }

    @Override
    public void fly() {
        throw new RuntimeException("你行你来...");
    }
}
