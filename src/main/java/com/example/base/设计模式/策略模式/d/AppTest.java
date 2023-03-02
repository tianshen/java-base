package com.example.base.设计模式.策略模式.d;

/**
 * 需求：
 * 有一家游戏公司，制作一款鸭子游戏，在这个鸭子游戏中，角色都是鸭子，不同的鸭子之间，有共性，所以为了提高代码的复用性，
 * 开发人员，就制作了一个鸭子的父类，Duck，把这些鸭子的共性上提到父类中。
 * <p>
 * 游戏公司的老总们开会，得出一个提高本公司游戏竞争力的方案，要求让游戏中的鸭子能飞起来，把其他竞争者远远甩在身后
 * <p>
 * 程序员会想，是时候展现我们面向对象程序员的威力了！我只需要在父类Duck中，添加一个fly方法。
 * 那么所有的鸭子都可以飞起来。
 * <p>
 * 此时问题看似解决了，但实际上出现了更麻烦的问题，所有Duck的子类鸭子，统统都会飞了。
 * 要知道，父类中的方法，并不是所有的子类都能通用的！！！
 * 比如：橡皮鸭！ 橡皮鸭是没有生命的，不能飞。 结果因为继承了Duck，搞得橡皮鸭也能飞！这样程序员就会背锅，被老总批评。
 * <p>
 * 针对b包中的问题，程序员需要判断每个鸭子子类，谁会不会叫，谁会不会飞，不会叫的，就重写quack方法，不会飞的就重写fly方法。
 * 这个工作量是很大的。
 * <p>
 * <p>
 * 我们希望那些不会飞的鸭子，压根就没有fly方法，不会叫的鸭子，压根就没有quack方法。
 * <p>
 * 把这2个经常在子类中变化的方法，从父类中分出来，分成两个接口： Quackable，Flyable
 * <p>
 * <p>
 * 是时候把飞行和叫方法，从鸭子类中分离出来了！（注意:这里的分离和c包中分离不一样）
 */

interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("用翅膀飞");
    }
}

class FlyWithRocket implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("背上绑个窜天猴");
    }
}

class FlyWithKick implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("一脚踢飞");
    }
}

class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("飞不起来");
    }
}

interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}

class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}

class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("沉默的叫");
    }
}

abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void swim() {
        System.out.println("游泳");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public abstract void display();

}

/**
 * 野鸭
 */
class MallarDuck extends Duck {

    public MallarDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是野鸭");
    }
}

/**
 * 红头鸭
 */
class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是红头鸭");
    }

}

/**
 * 橡皮鸭
 */
class RubberDuck extends Duck {

    public RubberDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }
}

/**
 * 诱饵鸭
 */
class DecoyDuck extends Duck {

    public DecoyDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("外观是诱饵鸭");
    }
}

public class AppTest {

    public static void main(String[] args) {
        // 红头鸭
        Duck duck = new RedHeadDuck();
        duck.swim();
        duck.performFly();
        duck.performQuack();
        duck.display();

        // 野鸭
        duck = new MallarDuck();
        duck.swim();
        duck.performFly();
        duck.performQuack();
        duck.display();

        // 橡皮鸭
        duck = new RubberDuck();
        duck.swim();
        duck.performFly();

        duck.setFlyBehavior(new FlyWithRocket());
        duck.performFly();
        duck.performQuack();
        duck.display();

        // 诱饵鸭
        duck = new DecoyDuck();
        duck.swim();
        duck.performFly();
        duck.performQuack();
        duck.display();
    }
}

/**
 * 思考为题解决了吗？
 * 以前是：，每加入一个新的鸭子角色，程序员就要判断，这个新鸭子角色是否会飞，是否会叫，不会飞就重写飞，不会叫就重写叫。
 * 现在是：，每加入一个新的鸭子角色，程序员就要判断，这个新鸭子角色是否会飞，是否会叫，不会飞就不实现Flyable接口，不会叫就不实现Quackable接口。
 * <p>
 * 如此，程序员仍然没有减少工作量，仍然要不断的判断新鸭子角色。
 * <p>
 * 另外一个缺点是fly和quack没有重用性可言，比如48中鸭子，有8种不会飞，那么飞方法就要在40个鸭子子类中一共重复40次。
 * <p>
 * 此时应有杠： 从jdk1.8开始，接口中的方法就有迷人实现！ 此时，48中鸭子，有8中不会飞，那么飞方法只需要在Flyable中定义一个默认实现的方法就可以。
 * <p>
 * 解释：
 * 对于48种鸭子，有12种飞行方法，又该如何！
 *
 *
 */
