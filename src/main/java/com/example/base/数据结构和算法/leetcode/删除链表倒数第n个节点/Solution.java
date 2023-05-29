package com.example.base.数据结构和算法.leetcode.删除链表倒数第n个节点;

class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //通过快慢指针来解决，类似于你要删除中间元素的题
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个伪节点，用于返回结果
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        //定义一个快指针,指向伪节点，用于遍历链表
        ListNode prev = dumpy;
        //定一个慢指针，
        ListNode tail = dumpy;
        //让快指针先移动 n 步
        while (n > 0) {
            prev = prev.next;
            n--;
        }
        //只要快指针不指向空，就继续循环
        while (prev.next != null) {
            //让快慢指针同时移动
            tail = tail.next;
            prev = prev.next;
        }
        //这时慢指针移动到的位置就是，要删除节点的前一个节点
        //所以只要删除当前节点的下一个节点
        tail.next = tail.next.next;
        //返回为指针指向的头节点
        return dumpy.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // 定义一个伪节点 用于返回数据
        ListNode dumpy = new ListNode(0);
        // 伪节点指向头节点
        dumpy.next = head;
        //定一个慢指针，
        ListNode slow = dumpy;
        //定义一个快指针,指向伪节点，用于遍历链表
        ListNode fast = dumpy;

        // 让快指针先向前移动n步
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        //只要快指针不指向空，就继续循环
        while (fast.next != null) {
            // 快慢指针一起执行
            slow = slow.next;
            fast = fast.next;
        }

        //这时慢指针移动到的位置就是，要删除节点的前一个节点
        //所以只要删除当前节点的下一个节点
        slow.next = slow.next.next;
        return dumpy.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        removeNthFromEnd2(head, 3);
    }


}