package com.example.base.数据结构和算法.leetcode.链表.链表反转;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;

/**
 * 链表反转
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Solution {

    public class DoubleNode {
        int val;
        DoubleNode next;
        DoubleNode last;

        DoubleNode(int x) {
            val = x;
        }
    }


    /**
     * 双向链表的逆序
     *
     * @param head
     * @return
     */
    public DoubleNode reverseList(DoubleNode head) {
        DoubleNode prev = null;
        DoubleNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            head.last = next;
            prev = head;
            head = next;
        }
        return prev;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 使用递归反转链表
     *
     * @param node
     * @return
     */
    public ListNode reverseListRecursion(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode newListNode = reverseListRecursion(node.next);
        node.next.next = node;
        node.next = null;
        return newListNode;
    }

    /**
     * 单链表的反转
     *
     * @param head
     * @return
     */
    public ListNode reverseList01(ListNode head) {

        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    /**
     * 链表翻转
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList08(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
