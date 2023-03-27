package com.example.base.数据结构和算法.书籍.链表.单向链表;

/**
 * 搞懂什么什么是引用
 * “引用”是成员变量 --- 指向一个对象
 */
public class LinkListX {

    private LinkX first;

    /**
     * 头节点插入
     *
     * @param id
     * @param dd
     */
    public void insertFirst(int id, int dd) {
        LinkX newLinkX = new LinkX(id, dd);
        newLinkX.next = first;
        first = newLinkX;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public LinkX deleteFirst() {
        LinkX temp = first;
        first = first.next;
        return temp;
    }

    /**
     * 遍历链表
     */
    public void display() {
        LinkX current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }


    public LinkX find(int id) {
        LinkX current = first;
        while (current != null) {
            if (current.iData == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * 删除指定的节点
     * @param id
     */
    public void delete(int id) {
        LinkX current = first;
        LinkX previous = first;

        if (current == null) {
            return;
        }

        while (current.iData != id) {
            if (current.next == null) {
                return;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }
}
