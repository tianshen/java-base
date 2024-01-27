package com.example.base.数据结构和算法.leetcode.链表.分隔链表;

public class Solution {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);

        ListNode partition = new Solution().partition(listNode, 3);
        System.out.println(partition.val);

    }

    public ListNode partition01(ListNode head, int target) {
        if (head == null) {
            return null;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode pre1 = dummy1;

        ListNode dummy2 = new ListNode(0);
        ListNode pre2 = dummy2;

        while (head != null) {
            if (head.val < target) {
                pre1.next = head;
                pre1 = pre1.next;
            } else {
                pre2.next = head;
                pre2 = pre2.next;
            }
            head = head.next;

            // 不能直接让 p 指针前进，
            // p = p.next
            // 断开原链表中的每个节点的 next 指针  总的来说，如果我们需要把原链表的节点接到新链表上，而不是 new 新节点来组成新链表的话，那么断开节点和原链表之间的链接可能是必要的。那其实我们可以养成一个好习惯，但凡遇到这种情况，就把原链表的节点断开，这样就不会出错了。
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        pre1.next = dummy2.next;
        return dummy1.next;
    }



    /**
     * 分隔链表
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        // 定义一个小链表   small和smallHead的作用是为了链表指针往后移动
        ListNode small = new ListNode(0);
        // smallHead引用small
        ListNode smallHead = small;

        // 定义一个大链表
        ListNode large = new ListNode(0);
        // largeHead引用large  这个是为了链接前面的节点
        ListNode largeHead = large;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}
