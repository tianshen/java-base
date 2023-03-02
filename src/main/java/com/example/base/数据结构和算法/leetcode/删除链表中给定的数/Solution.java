package com.example.base.数据结构和算法.leetcode.删除链表中给定的数;

public class Solution {

    public static class Node{
        int value;
        Node next;
        public Node(int v) {
            this.value = v;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(4);
        Node prev = delete(head, 3);
        //System.out.println(prev.value);
        while (prev != null) {
            System.out.println(prev.value);
            prev = prev.next;
        }
    }

    public static Node delete(Node head, int value) {
        if (head == null) {
            return head;
        }

        // 处理头节点
        while (head != null) {
            if (head.value == value) {
                head = head.next;
            } else {
                break;
            }
        }

        /**
         * 处理后面的节点
         */
        Node prev = head;
        Node cur = head.next;
        Node next;
        while (cur != null) {
            if (cur.value == value) {
                next = cur.next;
                prev.next = cur.next;
                cur = next;
            } else {
                next = cur.next;
                prev = cur;
                cur = next;
                //cur = cur.next;
            }
        }
        //处理第1种情况
//        Node prev = head;//前驱节点
//        //while循环的出口初学者不好确定，记住谁待删除，就找谁
//        while (prev.next != null){
//            if (prev.next.value == value) {
//                prev.next = prev.next.next;
//            }else{
//                prev = prev.next;
//            }
//        }
        return head;

    }
}
