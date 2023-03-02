package com.example.base.数据结构和算法.书籍.栈.链表实现栈;

/**
 * @author jiwei.xue
 * @date 2020/10/30 16:07
 */
public class Link {

    public long dData;

    public Link next;

    public Link(long dd) {
        this.dData = dd;
    }

    public void displayLink() {
        System.out.println(dData + "");
    }
}
