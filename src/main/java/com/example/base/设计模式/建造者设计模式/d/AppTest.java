package com.example.base.设计模式.建造者设计模式.d;

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

public class AppTest {

    public static void main(String[] args) {
        //创建一个建造者
        AdvancedComputerBuilder advancedComputerBuilder = new AdvancedComputerBuilder();
        advancedComputerBuilder.setCpu();
        advancedComputerBuilder.setGpu();
        advancedComputerBuilder.setMemory();
        advancedComputerBuilder.setHd();
        Computer computer1 = advancedComputerBuilder.build();
        System.out.println(computer1);

        MiddleComputerBuilder middleComputerBuilder = new MiddleComputerBuilder();
        middleComputerBuilder.setCpu();
        middleComputerBuilder.setGpu();
        middleComputerBuilder.setMemory();
        middleComputerBuilder.setHd();
        Computer computer2 = middleComputerBuilder.build();
        System.out.println(computer2);

        LowComputerBuilder lowComputerBuilder = new LowComputerBuilder();
        lowComputerBuilder.setCpu();
        lowComputerBuilder.setGpu();
        lowComputerBuilder.setMemory();
        lowComputerBuilder.setHd();
        Computer computer3 = lowComputerBuilder.build();
        System.out.println(computer3);
    }
}

/**
 * 这仍然不是建造者模式：
 * 优点：
 * 1、建造者类中的建造过程是稳定的，不会漏掉某一步，！！这样当客户端向扩展建造者时，也不会漏掉某一步。
 * <p>
 * 缺点:
 * 1、代码仍有重复。
 * 2、现在又变成了客户端自己组装电脑，又违反了迪米特法则。
 * （相当于，你去赛格电脑城配电脑，虽然不用你亲自组装电脑，但是你必须"指挥那个装机"boy"，该装...该装...）
 */
