package com.example.base.数据结构和算法.书籍.链表.单向链表;

public class LinkX {

    public int iData;

    public double dData;

    public LinkX next;

    public LinkX(int id, double dd) {
        this.iData = id;
        this.dData = dd;
    }

    public void displayLink() {
        System.out.println("{" + iData + ", " + dData + "} ");
    }
}
