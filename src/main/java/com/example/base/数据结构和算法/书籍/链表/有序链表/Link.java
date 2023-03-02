package com.example.base.数据结构和算法.书籍.链表.有序链表;

/**
 * @author jiwei.xue
 * @date 2020/10/30 14:11
 */
public class Link {

    public long dData;

    public Link next;

    public Link(long dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.println(dData + " ");
    }
}
