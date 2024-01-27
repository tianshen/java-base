package com.example.base.数据结构和算法.leetcode.链表.环形链表环的起点;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;

public class Solution {

    /**
     * 计算环的起点   从环的相遇点到环的起点 和 从头节点到环的起点之间的距离是一样的
     *
     * @param head
     * @return
     */
    public static ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        if (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
