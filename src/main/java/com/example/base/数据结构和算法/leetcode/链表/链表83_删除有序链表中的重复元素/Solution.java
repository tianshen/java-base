package com.example.base.数据结构和算法.leetcode.链表.链表83_删除有序链表中的重复元素;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;
import com.example.base.数据结构和算法.leetcode.链表.ListNodeUtil;

/**
 * @author xue
 * @date 2023/4/8 9:18
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * 删除有序链表中重复元素   如果两个元素重复，留1个
 */
public class Solution {
    public static ListNode deleteRepeatNodeFromSortListNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        int val = head.intValue;
        int dummyValue = val - 1;
        // 定义一个哑节点 返回数据使用
        ListNode dummy = new ListNode(dummyValue);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.intValue == cur.next.intValue) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // 生成链表
        ListNode head = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 3, 4, 4, 4, 5});
        // 旋转链表
        ListNode node = deleteRepeatNodeFromSortListNode(head);
        // 展示链表
        ListNodeUtil.display(node);

    }
}
