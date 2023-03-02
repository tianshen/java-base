package com.example.base.数据结构和算法.leetcode.分隔链表;

public class Solution {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);

        ListNode partition = new Solution().partition(listNode, 3);
        System.out.println(partition.val);

    }

    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0);
        ListNode smallHead = small;

        ListNode large = new ListNode(0);
        ListNode largeHead = large;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}
