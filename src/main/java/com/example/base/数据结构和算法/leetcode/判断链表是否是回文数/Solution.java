package com.example.base.数据结构和算法.leetcode.判断链表是否是回文数;

public class Solution {

    public static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome(Node head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        // 快慢指针找到中间元素
//        Node slow = head;
//        Node fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        // 将中间元素之后的进行逆序
//        Node pre = null;
//        Node cur = slow;
//        while (cur != null) {
//            Node next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
        return true;


    }
}
