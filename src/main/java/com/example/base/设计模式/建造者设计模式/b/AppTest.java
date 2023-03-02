package com.example.base.设计模式.建造者设计模式.b;

import lombok.Data;

/**
 * 定义一个电脑类，并且实例化出电脑类的对象，以及给该对象的属性赋值
 *
 * 针对A包中问题，修改代码如下：
 *  作者专门创建一个"ComputerBuilder"类，这个类专门负责封装组装电脑的过程！！
 */
@Data
class Computer {
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;
}

/**
 * 电脑建造者类，建造者类，必须关联电脑产品
 */
class ComputerBuilder {

    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i5 8750HK");
        computer.setGpu("rtx2080ti");
        computer.setHd("2T固态");
        computer.setMemory("32G");
        return computer;
    }
}

// =================================================================

public class AppTest {

    public static void main(String[] args) {
       //创建一个建造者
        ComputerBuilder computerBuilder = new ComputerBuilder();
        Computer computer1 = computerBuilder.build();
        System.out.println(computer1);

        Computer computer2 = computerBuilder.build();
        System.out.println(computer2);

        Computer computer3 = computerBuilder.build();
        System.out.println(computer3);
    }
}

/**
    目前这种写法还不是建造着模式
    目前的优点：
    1、客户端程序员需要一个产品时，直接向建造者要即可，建造者封装了创建电脑的"复杂"过程

    目前的缺点：
    1、封装的也太狠了！无论客户的需求是什么，都是采用最高配置，这相当于你去配电脑，无论是什么需求，商家都会给你配置最贵的电脑！！！
 */
