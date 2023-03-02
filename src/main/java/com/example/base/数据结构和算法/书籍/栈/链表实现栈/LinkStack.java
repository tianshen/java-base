package com.example.base.数据结构和算法.书籍.栈.链表实现栈;

/**
 * @author jiwei.xue
 * @date 2020/10/30 16:20
 */
public class LinkStack {

    private LinkList linkList;

    public LinkStack() {
        linkList = new LinkList();
    }

    public void push(long j) {
        linkList.insertFirst(j);
    }

    public long pop() {
        return linkList.deleteFirst();
    }

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void displayStakc() {
        linkList.displayList();
    }
}
