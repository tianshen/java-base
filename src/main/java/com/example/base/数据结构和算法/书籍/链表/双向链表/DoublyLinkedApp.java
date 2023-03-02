package com.example.base.数据结构和算法.书籍.链表.双向链表;

/**
 * @author jiwei.xue
 * @date 2020/12/24 17:32
 */
public class DoublyLinkedApp {

    public static void main(String[] args) {

        DoublyLinkedList theList = new DoublyLinkedList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward();
        theList.displayBackward();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);
        theList.displayForward();

        theList.insertAfter(22, 77);
        theList.insertAfter(33, 88);
        theList.displayForward();
    }
}
