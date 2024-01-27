package com.example.base.数据结构和算法.leetcode.链表.合并k个升序列表;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {


    public static ListNode mergeKListNode(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 使用优先级队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.intValue));

        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            // 将下一个节点放入到优先级队列中
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;

    }
}
