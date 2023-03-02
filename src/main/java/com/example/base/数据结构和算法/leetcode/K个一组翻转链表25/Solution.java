package com.example.base.数据结构和算法.leetcode.K个一组翻转链表25;

public class Solution {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(0);
        start.next = new ListNode(1);
        start.next.next = new ListNode(2);
        start.next.next.next = new ListNode(3);
        start.next.next.next.next = new ListNode(4);
        start.next.next.next.next.next = new ListNode(5);
        ListNode groupEnd = getKGroupEnd(start, 10);
        System.out.println(groupEnd.val);
    }
}
