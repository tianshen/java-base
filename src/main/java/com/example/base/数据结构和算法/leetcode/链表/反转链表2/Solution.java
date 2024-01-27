package com.example.base.数据结构和算法.leetcode.链表.反转链表2;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;

public class Solution {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    /**
     * 这种方式更好理解一点
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween02(ListNode head, int left, int right) {
        if (left == right) return head;

        // 总共3段sub1 sub2[left,right] sub3
        // 反转第二段sub2
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead, curr = head;
        int i = 1;
        for (; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }

        // 第一段的尾巴
        ListNode tail = prev;
        // 第二段反转后的尾巴
        ListNode newTail = curr;
        tail.next = null;
        prev = null;

        for (; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 现在curr是第3段的头
        newTail.next = curr;
        // 现在prev是第二段反转后的头
        tail.next = prev;
        return dummyHead.next;
    }
}
