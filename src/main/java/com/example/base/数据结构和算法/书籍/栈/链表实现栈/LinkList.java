package com.example.base.数据结构和算法.书籍.栈.链表实现栈;

/**
 * @author jiwei.xue
 * @date 2020/10/30 16:10
 * 链表实现栈
 */
public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        newLink.next = first;
        first = newLink;
    }

    public long deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp.dData;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
