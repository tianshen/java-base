package com.example.base.数据结构和算法.leetcode.删除排序链表中的重复元素;

public class Solution {

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int value) {
            val = value;
        }
    }

    public static void main(String[] args) {
        System.out.println("");
    }



    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
