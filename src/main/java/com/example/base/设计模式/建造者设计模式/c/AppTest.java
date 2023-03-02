package com.example.base.设计模式.建造者设计模式.c;

import lombok.Data;
import org.checkerframework.checker.units.qual.A;

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
 * 高端电脑建造者
 */
class AdvancedComputerBuilder {

    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i5 8750HK");
        computer.setGpu("rtx2080ti");
        computer.setHd("2T固态");
        computer.setMemory("32G");
        return computer;
    }
}

/**
 * 中端电脑建造者
 */
class MiddleComputerBuilder {

    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i5 7700hq");
        computer.setGpu("rtx1060");
        computer.setHd("1T固态");
        computer.setMemory("16G");
        return computer;
    }
}

/**
 * 低配电脑建造者
 */
class LowComputerBuilder {

    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 7500u");
        computer.setGpu("gtx940mx");
        computer.setHd("256G固态");
        computer.setMemory("8G");
        return computer;
    }
}

// =================================================================

public class AppTest {

    public static void main(String[] args) {
       //创建一个建造者
        AdvancedComputerBuilder computerBuilder = new AdvancedComputerBuilder();
        Computer computer1 = computerBuilder.build();
        System.out.println(computer1);

        MiddleComputerBuilder middleComputerBuilder = new MiddleComputerBuilder();
        Computer computer2 = middleComputerBuilder.build();
        System.out.println(computer2);

        LowComputerBuilder lowComputerBuilder = new LowComputerBuilder();
        Computer computer3 = lowComputerBuilder.build();
        System.out.println(computer3);
    }
}

/**
    这仍然不是建造者模式：
    优点：
    1、可以根据客户端的不同需求，使用不同的建造者来生产产品。

    缺点:
    1、我们发现，多个不同的建造者中的代码，在重复！既然代码中出现了重复的代码，那就有了"坏味道".
    2、建造者的过程不稳定，如果某个建造者创建产品的过程中，漏掉了某一步，编译器也不会报错！
        （相当于，KFC的某一家分店，制作汉堡包的流程突然少了摸一个流程，出来的汉堡包味道就变！ 因为没有标准）

 */
