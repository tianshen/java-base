package com.example.base.数据结构和算法.leetcode.链表;

/**
 * @author xue
 * @date 2023/4/8 10:42
 */
public class ListNodeUtil {

    /**
     * 展示链表元素
     * @param head
     */
    public static void display(ListNode head) {
        ListNode temp = head;
        if (temp == null) {
            System.out.println("head null");
            return;
        }
        while (temp != null) {
            System.out.println(temp.intValue);
            temp = temp.next;
        }
    }

    /**
     * 生成链表
     * @param arr
     * @return
     */
    public static ListNode generateListNode(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for (int i = 0; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return dummy.next;
    }

}
