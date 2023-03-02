package com.example.base.数据结构和算法.书籍.链表.单向链表;

/**
 * @author jiwei.xue
 * @date 2020/10/30 11:51
 */
public class Link {

    public int iData;

    public double dData;

    public Link next;

    public Link(int id, double dd) {
        this.iData = id;
        this.dData = dd;
    }

    public void displayLink() {
        System.out.println("{" + iData + ", " + dData + "} ");
    }
}
