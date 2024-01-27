package com.example.base.数据结构和算法.leetcode.链表.返回倒数第几个节点;

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


    /**
     * 返回倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode kthToLast02(ListNode head, int k) {
        ListNode first = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        ListNode second = head;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
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
