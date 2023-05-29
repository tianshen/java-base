package com.example.base.数据结构和算法.leetcode.链表.相交链表;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;

/**
 * @author xue
 * @date 2023/4/26 22:43
 */
public class Solution {

    public static void main(String[] args) {



    }

    /**
     * 相交链表
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
