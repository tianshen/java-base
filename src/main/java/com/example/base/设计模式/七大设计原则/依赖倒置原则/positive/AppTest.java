package com.example.base.设计模式.七大设计原则.依赖倒置原则.positive;
// =============================服务端代码=============================
interface Animal{
    void eat();
}

class Person {
    public void feed(Animal animal) {
        System.out.println("开始喂养");
        animal.eat();
    }
}

class Dog implements Animal{
    public void eat() {
        System.out.println("狗啃骨头");
    }
}

//==========================客户端代码============================================

// 变化来了：客户端不仅需要喂狗，还需要喂猫

//我们希望的是，当下层新增一个动物时，上层应该不知道，上层代码应该不用改动

class Cat implements Animal{
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

class Panda implements Animal {
    public void eat() {
        System.out.println("熊猫吃竹子");
    }
}

public class AppTest {

    public static void main(String[] args) {

        Person person = new Person();
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal panda = new Panda();

        person.feed(dog);
        person.feed(cat);
        person.feed(panda);

    }
}
