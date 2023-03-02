package com.example.base.数据结构和算法.书籍.链表.双端链表;

/**
 * @author jiwei.xue
 * @date 2020/10/30 14:11
 */
public class Link {

    public long dData;

    public Link next;

    public Link(long d) {
        dData = d;
    }

    public void displayLink() {
        System.out.println(dData + " ");
    }
}
