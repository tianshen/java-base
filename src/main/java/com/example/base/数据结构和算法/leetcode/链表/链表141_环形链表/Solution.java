package com.example.base.数据结构和算法.leetcode.链表.链表141_环形链表;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;
import com.example.base.数据结构和算法.leetcode.链表.ListNodeUtil;

/**
 * @author xue
 * @date 2023/4/8 15:35
 */
public class Solution {

    public static boolean hasCycle02(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.intValue == fast.intValue) {
                return true;
            }
        }
        return false;
    }


    /**
     * 是否有环
     * @param head
     * @return
     */
    public static boolean hasCycle01(ListNode head) {
        // 判空
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }



    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        // 当快指针和慢指针不相同的时候 则一直遍历
        while (slow != fast) {
            // 遍历的终止条件是快指针为null 或者快指针的下个指针为null，则说明没有环
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // 走到这一步说明快指针和慢指针重合了，重合就说明有环了
        return true;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 4, 5, 4});
        boolean b = hasCycle(head);
        System.out.println(b);
    }
}
