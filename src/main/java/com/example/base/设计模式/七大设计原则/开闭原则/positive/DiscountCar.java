package com.example.base.设计模式.七大设计原则.开闭原则.positive;

public class DiscountCar extends Car {
    @Override
    public double getPrice() {
        return super.getPrice() * 0.9;
    }
}
