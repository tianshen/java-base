package com.example.base.数据结构和算法.leetcode.链表.合并有序链表;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;
import com.example.base.数据结构和算法.leetcode.链表.ListNodeUtil;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int i) {
            this.val = i;
        }
    }


    public static ListNode mergeTwoListNode05(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null) {
            pre.next= l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return dummy.next;
    }






    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        ListNode head = head1.val < head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    /**
     * 合并两个有序链表  递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    /**
     * 合并两个有序链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        // 定义一个虚拟头结点，值为-1
        ListNode dummpHead = new ListNode(-1);
        // 设置一个指针指向虚拟头结点
        ListNode pre = dummpHead;
        while (list1 != null & list2 != null) {
            // 如果list1中元素小于list2中元素
            if (list1.val <= list2.val) {
                pre.next = list1;
                // list1指向下一位
                list1 = list1.next;
            } else {
                pre.next = list2;
                // list2指向下一位
                list2 = list2.next;
            }
            pre = pre.next;
        }
        // 如果list1中还有结点
        if (list1 != null) {
            pre.next = list1;
        }
        // 如果list2中还有结点
        if (list2 != null) {
            pre.next = list2;
        }
        return dummpHead.next;

    }


    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(9);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(7);
        ListNode listNode = mergeTwoListNode05(list1, list2);
        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
