package com.example.base.设计模式.策略模式.b;
/**
 * 需求：
 *  有一家游戏公司，制作一款鸭子游戏，在这个鸭子游戏中，角色都是鸭子，不同的鸭子之间，有共性，所以为了提高代码的复用性，
 *  开发人员，就制作了一个鸭子的父类，Duck，把这些鸭子的共性上提到父类中。
 *
 *  游戏公司的老总们开会，得出一个提高本公司游戏竞争力的方案，要求让游戏中的鸭子能飞起来，把其他竞争者远远甩在身后
 *
 *  程序员会想，是时候展现我们面向对象程序员的威力了！我只需要在父类Duck中，添加一个fly方法。
 *  那么所有的鸭子都可以飞起来。
 *
 *  此时问题看似解决了，但实际上出现了更麻烦的问题，所有Duck的子类鸭子，统统都会飞了。
 *  要知道，父类中的方法，并不是所有的子类都能通用的！！！
 *  比如：橡皮鸭！ 橡皮鸭是没有生命的，不能飞。 结果因为继承了Duck，搞得橡皮鸭也能飞！这样程序员就会背锅，被老总批评。
 */

abstract class Duck {
    public void quack() {
        System.out.println("嘎嘎");
    }

    public void swim() {
        System.out.println("游泳");
    }

    public abstract void display();

    public void fly() {
        System.out.println("我飞！！！");
    }
}

class MallarDuck extends Duck {

    @Override
    public void display() {
        System.out.println("外观是野鸭");
    }
}

class RedHeadDuck extends Duck {

    @Override
    public void display() {
        System.out.println("外观是红头鸭");
    }
}

class RubberDuck extends Duck {

    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }

    // 因为橡皮鸭不会飞，却又继承了Duck中的fly方法，所以我们可以像重写quack方法那样，去重写fly方法。

    @Override
    public void fly() {
        System.out.println("you can you up....(橡皮鸭最终没有飞起来)");
    }
}

public class AppTest {

    public static void main(String[] args) {

        Duck duck = new RubberDuck();
        duck.quack();
        duck.swim();
        duck.fly();
        duck.display();
    }
}

/**
 * 看起来，问题好像解决了，但是并没有，问题是，变化不断出现，一会加个木头鸭子，一会加个鸭子超人，一会加个怪鸭伯爵。
 * 程序员就要在每次添加新的鸭子角色时，都会判断，新的鸭子角色会不会叫，会不会飞，针对不同鸭子，更有不同的处理方式，
 * 这样也很麻烦，只不过是从一个噩梦跳入了另一个噩梦。
 */
