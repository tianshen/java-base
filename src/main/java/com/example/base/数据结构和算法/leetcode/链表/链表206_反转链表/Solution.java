package com.example.base.数据结构和算法.leetcode.链表.链表206_反转链表;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;
import com.example.base.数据结构和算法.leetcode.链表.ListNodeUtil;

/**
 * @author xue
 * @date 2023/4/8 17:08
 */
public class Solution {

    public static ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode node = reverseList(head);
        ListNodeUtil.display(node);
    }
}
