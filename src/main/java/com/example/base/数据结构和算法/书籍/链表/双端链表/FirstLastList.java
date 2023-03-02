package com.example.base.数据结构和算法.书籍.链表.双端链表;

/**
 * @author jiwei.xue
 * @date 2020/10/30 14:13
 * 什么是双端链表？
 *
 */
public class FirstLastList {

    private Link first;

    private Link last;

    public FirstLastList() {
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

    /**
     * 在链表头部添加
     * @param dd
     */
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        // 双端链表，在链表头部添加
        // 如果链表为空的话，则相当于是添加了一个新的连接点，这样first，last都要指向新添加的节点
        // 如果链表不为空，说明last已经指向尾节点，只需要改变头节点的指向。
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    /**
     * 在链表尾部添加
     * @param dd
     */
    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        // 双端链表，在链表尾部添加
        // 如果链表为空的话，则相当于是添加了一个新的连接点，这样first，last都要指向新添加的节点
        // 如果链表不为空，说明last已经指向尾节点，只需要改变头节点的指向。
        if (isEmpty()) {
            // first指向新节点
            first = newLink;
        } else {
            // last指向新节点
            last.next = newLink;
        }
        // last指向新节点
        last = newLink;
    }

    /**
     * 删除头节点
     * @return
     */
    public long deleteFirst() {
        long temp = first.dData;
        // 如果first.next为空，说明只有一个节点，删除之后链表中不存在节点，所以last指向空。
        if (first.next == null) {
            last = null;
        }

        first = first.next;
        return temp;
    }

    /**
     * 遍历链表
     */
    public void displayList() {
        System.out.println("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
