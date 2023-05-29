package com.example.base.数据结构和算法.leetcode.链表.链表61_旋转链表;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;
import com.example.base.数据结构和算法.leetcode.链表.ListNodeUtil;

/**
 * @author xue
 * @date 2023/4/8 9:18
 * https://cloud.tencent.com/developer/article/1572249
 */
public class Solution {
    public static ListNode reverseList(ListNode head) {
        // 定义一个哑节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;


        return null;
    }

    public static void main(String[] args) {
        // 生成链表
        ListNode head = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 4, 5});
        // 旋转链表
        ListNode node = reverseList(head);
        // 展示链表
        ListNodeUtil.display(node);

    }
}
