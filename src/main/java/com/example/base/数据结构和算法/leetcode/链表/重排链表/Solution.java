package com.example.base.数据结构和算法.leetcode.链表.重排链表;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 使用容器进行排序
     *
     * @param head
     */
    public static void recorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     * 不使用容器进行重排
     */
    public static void recorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        //1.通过快慢指针找到中节点
        ListNode mid = middleNode(head);

        ListNode l1 = head;
        ListNode l2 = mid.next;

        mid.next = null;

        //2.反转中点之后的链表 生成新的链表
        l2 = reverseList(l2);

        //3. 合并链表
        merge(l1, l2);

    }

    /**
     * 通过快慢指针找到中间节点
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 将链表中结点的右边反转  将链表中节点的右边反转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 合并两个链表
     * @param l1
     * @param l2
     * @return
     */
    public static void merge(ListNode l1, ListNode l2) {
        ListNode l1Temp;
        ListNode l2Temp;
        while (l1 != null && l2 != null) {
            l1Temp = l1.next;
            l2Temp = l2.next;

            l1.next = l2;
            l1 = l1Temp;

            l2.next = l1;
            l2 = l2Temp;
        }
    }

}
