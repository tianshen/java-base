package com.example.base.数据结构和算法.leetcode.返回倒数第几个节点;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public int kthToLast(ListNode head, int k) {

        ListNode first = head;
        ListNode second = head;

        while (k-- > 0) {
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second.val;

    }


}
