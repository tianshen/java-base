package com.example.base.数据结构和算法.书籍.链表.双向链表;

/**
 * @author jiwei.xue
 * @date 2020/12/24 16:19
 */
public class Link {

    public long dData;
    public Link next;
    public Link previous;

    public Link(long d) {
        this.dData = d;
    }

    public void displayLink() {
        System.out.println(dData + " ");
    }
}
