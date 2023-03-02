package com.example.base.数据结构和算法.leetcode.两两交换链表中的节点;

public class Solution {

    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 使用递归的方式 两两交换节点
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 使用循环的方式 进行两两节点之间的交换
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        // 定义一个哑节点
        ListNode dummyNode = new ListNode(0);
        // 哑节点指向头节点
        dummyNode.next = head;
        // 给哑节点定义一个临时变量
        ListNode temp = dummyNode;
        // 当哑节点的后面两个节点都不是空的时候 进行交换
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            dummyNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyNode.next;
    }
}
