package com.example.base.数据结构和算法.leetcode.链表.链表876_链表的中间节点;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;
import com.example.base.数据结构和算法.leetcode.链表.ListNodeUtil;

/**
 * @author xue
 * @date 2023/4/8 16:36
 */
public class Solution {


    /**
     * 找中间节点
     * @param head
     * @return
     */
    public static ListNode findMidNode02(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 快慢指针的方法
     *
     * @param head
     * @return
     */
    public static ListNode findMidNode(ListNode head) {
//        if (head.next == null) {
//            return head;
//        }
//        if (head.next.next == null) {
//            return head.next;
//        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode node = findMidNode(head);
        ListNodeUtil.display(node);
    }
}
