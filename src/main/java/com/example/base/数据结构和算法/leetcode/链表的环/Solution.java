package com.example.base.数据结构和算法.leetcode.链表的环;

/**
 * 判断一个链表中是否有环
 * 方法一： 遍历链表，将链表中的每一个节点放到一个hashSet中，如果有环的话，则第一个放进去重复的数据就是环的头节点
 */
public class Solution {


    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
