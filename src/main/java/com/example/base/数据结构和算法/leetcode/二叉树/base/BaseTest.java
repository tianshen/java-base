package com.example.base.数据结构和算法.leetcode.二叉树.base;

/**
 * @author xue
 * @date 2023/4/10 20:15
 */

class ListNode {

    int val;

    ListNode next;

    ListNode() {

    }

    ListNode (int val) {
        this.val = val;
    }
}

/**
 * @author eunhye
 */
public class BaseTest {

    /**
     * 递归调用
     * @param head
     */
    public static void printList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        printList(head.next);
    }

    public static ListNode addList(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val);
        }
        head.next = addList(head.next, val);
        return head;
    }


    public static void main(String[] args) {

    }
}
