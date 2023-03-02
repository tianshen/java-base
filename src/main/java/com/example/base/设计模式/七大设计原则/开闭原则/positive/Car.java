package com.example.base.设计模式.七大设计原则.开闭原则.positive;

public class Car {

    private String brand;
    private String color;
    private boolean louyou;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isLouyou() {
        return louyou;
    }

    public void setLouyou(boolean louyou) {
        this.louyou = louyou;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", louyou=" + louyou +
                ", price=" + price +
                '}';
    }
}
