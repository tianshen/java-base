package com.example.base.数据结构和算法.leetcode.链表.链表快慢指针;

/**
 * 快慢指针
 * 1) 输入链表的头节点 奇数长短返回中点 偶数长度返回上中点
 * 2) 输入链表的头节点 奇数长短返回中点 偶数长度返回下中点
 * 3) 输入链表的头节点 奇数长短返回中点前一个 偶数长度返回上中点前一个
 * 4) 输入链表的头节点 奇数长短返回中点前一个 偶数长度返回下中点前一个
 */

public class Solution {

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 1) 输入链表的头节点 奇数长短返回中点 偶数长度返回上中点
     *
     * @param head
     * @return
     */
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 2) 输入链表的头节点 奇数长短返回中点 偶数长度返回下中点
     *
     * @param head
     * @return
     */
    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head.next;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 3) 输入链表的头节点 奇数长短返回中点前一个 偶数长度返回上中点前一个
     *
     * @param head
     * @return
     */
    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 4) 输入链表的头节点 奇数长短返回中点前一个 偶数长度返回下中点前一个
     *
     * @param head
     * @return
     */
    public static Node midOrDownMidNextNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
