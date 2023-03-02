package com.example.base.数据结构和算法.书籍.链表.双向链表;

/**
 * @author jiwei.xue
 * @date 2020/12/24 16:22
 */
public class DoublyLinkedList {

    private Link first;
    private Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 在链表的头部添加节点
     *
     * @param dd
     */
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }


    /**
     * 在链表尾部添加节点
     *
     * @param dd
     */
    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    /**
     * 在指定节点后面添加节点
     *
     * @param key
     * @param dd
     * @return
     */
    public boolean insertAfter(long key, long dd) {
        // 第一个节点
        Link current = first;
        // 循环找到key对应的节点
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }   // 结束循环 找到对应的节点

        Link newLink = new Link(dd);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        current.next = newLink;
        newLink.previous = current;
        return true;
    }

    /**
     * 删除头部节点
     *
     * @return
     */
    public Link deleteFirst() {
        Link temp = first;
        // 如果只有一个节点 删除之后就没有节点啦
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    /**
     * 删除尾部节点
     *
     * @return
     */
    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    /**
     * 删除指定节点
     *
     * @param key
     * @return
     */
    public Link deleteKey(long key) {
        Link current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.previous.next = current.next;
        }
        return current;
    }

    /**
     * 从前向后遍历输出
     */
    public void displayForward() {
        System.out.println("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    /**
     * 从后向前遍历输出
     */
    public void displayBackward() {
        System.out.println("List(last-->first): ");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }

}
