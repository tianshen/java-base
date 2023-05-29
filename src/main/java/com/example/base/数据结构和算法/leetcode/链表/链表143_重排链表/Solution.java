package com.example.base.数据结构和算法.leetcode.链表.链表143_重排链表;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;
import com.example.base.数据结构和算法.leetcode.链表.ListNodeUtil;

/**
 * @author xue
 * @date 2023/4/8 17:37
 */
public class Solution {

    public static void main(String[] args) {

        ListNode head = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        reorderList(head);
        // ListNodeUtil.display(node);
    }

    /**
     * 找中点+反转后半部分+合并前后两部分
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // 1. 找中点，让slow指向中点，或左中点位置
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 断开中点，反转后半部分
        ListNode head2 = null, next = slow.next;
        slow.next = null;
        slow = next;
        while (slow != null) {
            next = slow.next;
            slow.next = head2;
            head2 = slow;
            slow = next;
        }

        // 3. 合并链表head和head2
        ListNode curr = head;
        ListNode curr2 = head2;
        while (curr != null && curr2 != null) {
            next = curr.next;
            curr.next = curr2;
            curr2 = curr2.next;
            curr.next.next = next;
            curr = next;
        }
    }

    public static ListNode againSortListNode(ListNode head) {

        // 第一步找到链表中心节点
        ListNode mid = findMidListNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;

        // 对后面的节点进行翻转
        l2 = reverseListNode(l2);

        return null;
    }


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 找到中点
     *
     * @param head
     * @return
     */
    private static ListNode findMidListNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
