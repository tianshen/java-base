package com.example.base.设计模式.建造者设计模式.a;

import lombok.Data;

/**
 * 定义一个电脑类，并且实例化出电脑类的对象，以及给该对象的属性赋值
 */
@Data
class Computer {
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;
}

// =================================================================

public class AppTest {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setCpu("i7 7500u");
        computer.setGpu("gt940mx");
        computer.setHd("1T机械");
        computer.setMemory("16G");
        System.out.println(computer);
    }
}

/**
 * 这样做的缺点:
 *  1、客户端程序员，在实例化好产品的对象之后，必须为该对象的每一个属性赋值，这样对于客户端程序员来说，太麻烦了！！！
 *  2、违反了迪米特法则！！！
 *
 *  这相当于你去赛格去配电脑，商家把零件全给你，你自己组装电脑！
 *
 *  建造者模式和工厂模式的区别：
 *      工厂模式，都是直接实例化出一个类的对象即可。
 *      建造者模式，是在实例化出来的对象之后，还要给该对象的属性赋值！
 */
