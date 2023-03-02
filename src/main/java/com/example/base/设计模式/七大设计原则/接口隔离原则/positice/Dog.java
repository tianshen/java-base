package com.example.base.设计模式.七大设计原则.接口隔离原则.positice;

public class Dog implements Eatable, Swimable{
    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗刨");
    }
}
