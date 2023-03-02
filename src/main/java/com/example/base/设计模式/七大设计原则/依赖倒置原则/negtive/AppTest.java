package com.example.base.设计模式.七大设计原则.依赖倒置原则.negtive;


class Person {
    public void feed(Dog dog) {
        System.out.println("开始喂养");
        dog.eat();
    }

    public void feed(Cat cat) {
        System.out.println("开始喂养");
        cat.eat();
    }
}

class Dog {
    public void eat() {
        System.out.println("狗啃骨头");
    }
}

//================================================================================

// 变化来了：客户端不仅需要喂狗，还需要喂猫

// 客户端自定义一个猫类

//此时 这种代码违反了依赖倒置，因为，每当下层变动时，上层都要跟着一起变动

//我们希望的是，当下层新增一个动物时，上层应该不知道，上层代码应该不用改动

class Cat {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

public class AppTest {

    public static void main(String[] args) {

        Person person = new Person();
        Dog dog = new Dog();
        Cat cat = new Cat();

        person.feed(dog);
        person.feed(cat);

    }
}
