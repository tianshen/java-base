package com.example.base.数据结构和算法.leetcode.链表.分隔链表;

public class Solution {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);

        ListNode partition = new Solution().partition(listNode, 3);
        System.out.println(partition.val);

    }

    /**
     * 分隔链表
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        // 定义一个小链表   small和smallHead的作用是为了链表指针往后移动
        ListNode small = new ListNode(0);
        // smallHead引用small
        ListNode smallHead = small;

        // 定义一个大链表
        ListNode large = new ListNode(0);
        // largeHead引用large
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
