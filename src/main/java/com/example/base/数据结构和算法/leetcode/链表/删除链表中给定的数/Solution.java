package com.example.base.数据结构和算法.leetcode.链表.删除链表中给定的数;

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


    /**
     * 删除指定的节点
     * @param head
     * @param value
     * @return
     */
    public static Node delete02(Node head, int value) {
        if (head == null) {
            return null;
        }
        // 处理头节点
        while (head != null) {
            if (head.value == value) {
                head = head.next;
            } else {
                break;
            }
        }

        if (head == null) {
            return null;
        }

        // 处理后面的节点 节点引用问题
        Node pre = head;
        Node cur = head.next;

        Node next;
        while (cur != null) {
            next = cur.next;
            if (cur.value == value) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return head;

    }






    public static Node delete(Node head, int value) {
        if (head == null) {
            return null;
        }

        // 处理头节点
        while (head != null) {
            if (head.value == value) {
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null) {
            return null;
        }

        /**
         * 处理后面的节点   链表的指向问题
         */
        Node prev = head;
        Node cur = head.next;
        Node next;
        while (cur != null) {
            next = cur.next;
            if (cur.value == value) {
                prev.next = next;
                cur = next;
            } else {
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
