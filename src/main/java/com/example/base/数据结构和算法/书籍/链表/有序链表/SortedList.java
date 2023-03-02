package com.example.base.数据结构和算法.书籍.链表.有序链表;

/**
 * 有序链表的实现
 */
public class SortedList {

    private Link first;

    public SortedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(long key) {
        //创建一个新的节点
        Link newLink = new Link(key);
        // 定义前继节点和当前节点
        Link previous = null;
        Link current = first;

        while (current != null && key > current.dData) {
            previous = current;
            current = current.next;
        }
        // 说明当前节点为空，说明链表中没有节点
        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }
}
