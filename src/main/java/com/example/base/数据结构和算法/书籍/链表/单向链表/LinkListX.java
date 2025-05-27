package com.example.base.数据结构和算法.书籍.链表.单向链表;

/**
 * 搞懂什么什么是引用
 * “引用”是成员变量 --- 指向一个对象
 */
public class LinkListX {

    /**
     * 链表中第一个链接点的引用，它是唯一的链表需要维护的永久信息
     */
    private LinkX first;

    /**
     * 头节点插入
     *
     * @param id
     * @param dd
     */
    public void insertFirst(int id, int dd) {
        LinkX newLinkX = new LinkX(id, dd);
        // first字段只是一个“引用”，这个引用的值就是一个链接点的内存地址，
        // 所以新创建的节点的next = first，表示将新创建的节点链接到原来的头结点
        newLinkX.next = first;
        // first链接到新创建的节点上
        first = newLinkX;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public LinkX deleteFirst() {
        // 当前的first的值其实就是头结点
        LinkX temp = first;
        // 修改first的值，把first指向头结点的下一个节点，也就是 first = first.next;
        first = first.next;
        // 返回头结点
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
     * 删除指定的节点   删除指定节点
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
