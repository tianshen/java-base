package com.example.base.设计模式.原型模式.c;

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
        WeekReport clone = (WeekReport)super.clone();
        Date clone2 = (Date) clone.getTime().clone();
        clone.setTime(clone2);
        return clone;
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

        WeekReport weekReport2 = (WeekReport)weekReport.clone();
        System.out.println(weekReport == weekReport2);

        weekReport2.getTime().setTime(0);
        System.out.println(weekReport);
        System.out.println(weekReport2);

        
        // 目前已经达到了深拷贝的目的，也就是修改副本对象的任何属性，都对原有对象没有任何影响！！
        // 问题是:
        //   如果对象的深度比较深

    }
}
