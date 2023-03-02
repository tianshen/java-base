package com.example.base.设计模式.七大设计原则.组合优于继承.a;

import java.util.HashSet;

/**
 * 需求: 制作一个集合，要求该集合能记录曾经加过多少元素 （不是统计某一时刻集合中有多少元素）
 */

/**
 * 使用继承的方式来统计
 */
class MySet extends HashSet<String> {
    private int count = 0;

    @Override
    public boolean add(String s) {
        this.count++;
        return super.add(s);
    }

    public int getCount() {
        return this.count;
    }
}

public class AppTest {

    public static void main(String[] args) {
        MySet set = new MySet();
        set.add("a");
        set.add("b");
        set.add("c");

        System.out.println(set.getCount());
    }
}
