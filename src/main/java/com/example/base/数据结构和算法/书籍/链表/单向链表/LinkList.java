package com.example.base.数据结构和算法.书籍.链表.单向链表;

/**
 * @author jiwei.xue
 * @date 2020/10/30 11:55
 */
public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 添加头节点
     *
     * @param id
     * @param dd
     */
    public void insertFirst(int id, double dd) {
        // 创建一个新的节点
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    /**
     * 删除第一个节点
     *
     * @return
     */
    public Link deleteFirst() {
        Link temp = first;
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

    /**
     * 查找指定key的节点
     * @param key
     * @return
     */
    public Link find(int key) {
        Link current = first;
        while(current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    /**
     * 删除指定节点
     * @param key
     * @return
     */
    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        while (current.iData != key) {
            if (current.next == null) {
                return null;
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
        return current;
    }

}
