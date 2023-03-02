package com.example.base.设计模式.七大设计原则.迪米特法则最少知道原则.positive;

/**
 * 迪米特法则的核心思想就是封装
 * 一个对象对另一个对象知道的越少越好，这样可以
 */
class Computer {

    private void saveData() {
        System.out.println("保存数据");
    }

    private void killProcess() {
        System.out.println("关闭程序");
    }

    private void closeScreen() {
        System.out.println("关闭屏幕");
    }

    private void powerOff() {
        System.out.println("断电");
    }

    public void shutdown() {
        saveData();
        killProcess();
        closeScreen();
        powerOff();
    }
}

class Person {
    private Computer c = new Computer();

    public void shutdownComputer() {
      c.shutdown();
    }
}

public class AppTest {

    public static void main(String[] args) {

        Person person = new Person();
        person.shutdownComputer();
    }
}
