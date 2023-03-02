package com.example.base.设计模式.七大设计原则.迪米特法则最少知道原则.negtive;


class Computer {

    public void saveData() {
        System.out.println("保存数据");
    }

    public void killProcess() {
        System.out.println("关闭程序");
    }

    public void closeScreen() {
        System.out.println("关闭屏幕");
    }

    public void powerOff() {
        System.out.println("断电");
    }
}

// 此时，这个person对于computer的细节知道的太多了。
// 对于person而言，只需要知道，关机按钮在哪就行，不需要知道如何保存数据，如何关闭进程，如何断电等等这些细节...
// 这样的话 代码的复杂度就提高了  万一用户使用补档，就有可能造成重大损失
class Person {
    private Computer c = new Computer();

    public void shutdownComputer() {
        c.saveData();
        c.killProcess();
        c.closeScreen();
        c.powerOff();
    }
}

public class AppTest {

    public static void main(String[] args) {

        Person person = new Person();
        person.shutdownComputer();
    }
}
