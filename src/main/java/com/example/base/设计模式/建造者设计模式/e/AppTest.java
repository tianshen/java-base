package com.example.base.设计模式.建造者设计模式.e;

import lombok.Data;

/**
 * 定义一个电脑类，并且实例化出电脑类的对象，以及给该对象的属性赋值
 * <p>
 * 创建一个建造者接口，把制作产品的具体步骤，稳定下来！ （解决稳定性）
 * 我们让建造者类，去实现建造者接口，接口中的方法步骤，类就必须都要实现，少实现一个抽象方法就会报错！
 */
@Data
class Computer {
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;
}

class Director {
    public Computer build (ComputerBuild computerBuild) {
        computerBuild.setCpu();
        computerBuild.setGpu();
        computerBuild.setMemory();
        computerBuild.setHd();
        return computerBuild.build();
    }
}

/**
 * 创建建造者接口，将制作产品的步骤稳定下来！！
 */
interface ComputerBuild {
    void setCpu();

    void setGpu();

    void setMemory();

    void setHd();

    Computer build();
}

/**
 * 高端电脑建造者
 */
class AdvancedComputerBuilder implements ComputerBuild {

    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("i5 8750HK");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx2080ti");
    }

    @Override
    public void setMemory() {
        computer.setMemory("32G");

    }

    @Override
    public void setHd() {
        computer.setHd("2T固态");
    }

    public Computer build() {
        return computer;
    }
}

/**
 * 中端电脑建造者
 */
class MiddleComputerBuilder implements ComputerBuild {

    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("i5 7700hq");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx1060");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16G");
    }

    @Override
    public void setHd() {
        computer.setHd("1T固态");
    }

    public Computer build() {
        return computer;
    }
}

/**
 * 低配电脑建造者
 */
class LowComputerBuilder implements ComputerBuild{

    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("i7 7500u");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx940mx");
    }

    @Override
    public void setMemory() {
        computer.setMemory("8G");
    }

    @Override
    public void setHd() {
        computer.setHd("256G固态");
    }

    public Computer build() {
        return computer;
    }
}

// =================================================================

class MiddleHighComputerBuilder implements ComputerBuild {

    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("i5 8500hq");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx1070");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16g");
    }

    @Override
    public void setHd() {
        computer.setHd("250固态+机械");
    }

    @Override
    public Computer build() {
        return computer;
    }
}

public class AppTest {

    public static void main(String[] args) {
        // 高配
        AdvancedComputerBuilder advancedComputerBuilder = new AdvancedComputerBuilder();
        // 中配
        MiddleComputerBuilder middleComputerBuilder = new MiddleComputerBuilder();
        // 低配
        LowComputerBuilder lowComputerBuilder = new LowComputerBuilder();

        Director director = new Director();
        Computer computer = director.build(advancedComputerBuilder);
        System.out.println(computer);
        computer = director.build(middleComputerBuilder);
        System.out.println(computer);
        computer = director.build(lowComputerBuilder);
        System.out.println(computer);

        MiddleHighComputerBuilder middleHighComputerBuilder = new MiddleHighComputerBuilder();
        computer = director.build(middleHighComputerBuilder);
        System.out.println(computer);

    }
}

/**
 * 这就是建造者模式：
 * 优点：
 * 1、创建对象的过程稳定不变的（因为ComputerBuilder接口来稳定过程）
 * 2、创建对象的过程只写了一次，没有重复代码（指挥者完成）
 * 3、当需要扩展指挥者的时候，不需要修改之前的代码，这符合了开闭原则
 *
 */
