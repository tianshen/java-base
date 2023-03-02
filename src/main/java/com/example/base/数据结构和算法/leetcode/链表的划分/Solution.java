package com.example.base.数据结构和算法.leetcode.链表的划分;

public class Solution {

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartition(Node head, int value) {

        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        Node next;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < value) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == value) {
                if (eH == null) {
                    eH = head;
                    eH = head;
                } else {
                    eH.next = head;
                    eH = head;
                }
            } else if (head.value > value) {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mH.next = head;
                    mH = head;
                }
            }
            head = next;
        }

        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if (eT != null) {
            eT.next = mT;
        }
        return sH != null ? sH : (eH != null ? eH : mH);

    }


}
