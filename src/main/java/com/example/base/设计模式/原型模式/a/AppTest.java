package com.example.base.设计模式.原型模式.a;

import lombok.Data;

import java.util.Date;

/**
 * 使用原型模式来解决这个问题：
 * 1、必须让目标类实现Cloneable接口，该接口中没有任何抽象方法。 这样的接口仅仅是一个"标记接口"，作用是告诉jvm，
 * 任何实现了该Cloneable接口的对象，可以被克隆！！
 * 2、必须重写java.lang.Object的clone方法，一定要把该方法的访问修饰符，重写为public！！ 不然无法调用clone方法。
 */

@Data
class WeekReport implements Cloneable{
    private int id;
    private String emp;
    private String summary;
    private String plain;
    private String suggestion;
    private Date time;

    public WeekReport() {
        System.out.println("判断克隆的时候会不会调用呢？");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class AppTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        // 第一周周报
        WeekReport weekReport = new WeekReport();
        weekReport.setEmp("毛毛");
        weekReport.setSummary("讲解完7大原则");
        weekReport.setPlain("讲解完设计模式");
        weekReport.setSuggestion("无");
        weekReport.setTime(new Date());

        // 第二周周报  问题是，尽管第二周周报的大部分内容与第一周周报的内容一致，但是仍然要重复设置！！！！（等同于在表单中填写一样的内容）
//        WeekReport weekReport2 = new WeekReport();
//        weekReport2.setEmp("毛毛");
//        weekReport2.setSummary("讲解完html");
//        weekReport2.setPlain("讲解完css");
//        weekReport2.setSuggestion("无");
//        weekReport2.setTime(new Date());
//
//        System.out.println(weekReport2);
        // 浅克隆
        // 克隆weekReport对象，得到一个新对象
        // 思考1：clone方法，会不会引起构造器的调用？ 不会！ 那么这个clone方法是如何实现克隆对象的效果呢？
        // clone方式是直接赋值内存中的2进制。效率更高！！！！

        // 思考2：既然clone方法没有引起构造器的调用，那么克隆出的对象和原先的对象，地址是否一致？？ 不一致。
        // 最终是两个不同空间中的对象
        WeekReport weekReport2 = (WeekReport)weekReport.clone();
//        weekReport2.setSummary("讲解完html");
//        weekReport2.setPlain("讲解完css");
        System.out.println(weekReport == weekReport2);

        // 问题是：修改了其中一个对象的属性，另一个对象的属性是否会变化？
        // Date类的setTime是用来设置毫秒数的，这个毫秒数是自1970.1.1 00：00：00 以来的毫秒数
        // 下面修改了weekReport2的time属性，而weekReport的time字段也一起被修改了！ 为什么呢？？ 因为，目前这种克隆方式是"浅拷贝".
        // 所谓的浅拷贝就是把原来的对象的2进制，原样赋值！！  如果是引用类型的话，复制的是对象的地址，则指向同一个对象。
        weekReport2.getTime().setTime(0);
        System.out.println(weekReport);
        System.out.println(weekReport2);


        // 我们希望克隆出来的副本对象，无论怎么修改它，都不会影响原来的对象！！






    }
}
