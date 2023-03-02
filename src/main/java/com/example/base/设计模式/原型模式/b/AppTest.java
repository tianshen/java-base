package com.example.base.设计模式.原型模式.b;

import lombok.Data;

import java.io.*;
import java.util.Date;

/**
 * 使用原型模式来解决这个问题：
 * 1、必须让目标类实现Cloneable接口，该接口中没有任何抽象方法。 这样的接口仅仅是一个"标记接口"，作用是告诉jvm，
 * 任何实现了该Cloneable接口的对象，可以被克隆！！
 * 2、必须重写java.lang.Object的clone方法，一定要把该方法的访问修饰符，重写为public！！ 不然无法调用clone方法。
 */

@Data
class WeekReport implements Cloneable, Serializable {
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
        Object clone;
        try {
            // 将当前对象写道a.txt文件中
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this);   // 序列化时，对象的所有属性层级关系会被序列化自动处理！！！
            oos.close();

            // 从内存中读取
            byte[] bb = out.toByteArray();
            InputStream in = new ByteArrayInputStream(bb);
            ObjectInputStream ois = new ObjectInputStream(in);
            clone = ois.readObject();
            ois.close();

            System.out.println(this == clone);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

        // 序列化本身就是深克隆

        // 此时，利用序列化和反序列化，已经简化了深拷贝的写法。

        // 问题是：
        //     序列化的目标位置是写死的，位置不应该写死！ linux下没有盘符！！！
        //   这才是我们推荐的写法。
    }
}
