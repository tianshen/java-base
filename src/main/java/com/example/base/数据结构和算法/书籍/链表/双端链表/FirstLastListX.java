package com.example.base.数据结构和算法.书籍.链表.双端链表;

/**
 * @author jiwei.xue
 * @date 2020/10/30 14:13
 * 什么是双端链表？
 */
public class FirstLastListX {

    private Link first;

    private Link last;

    public FirstLastListX() {
        first = null;
        last = null;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        Link link = new Link(dd);
        if (isEmpty()) {
            last = link;
        }
        link.next = first;
        first = link;
    }
}
