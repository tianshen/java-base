package com.example.base.值传递和引用传递;

/**
 * @author xue
 * @date 2023/4/8 0:27
 */
public class QuoteAndValueTransferTest {

    static class ListNode {
        int value;
        ListNode next = null;
        ListNode (int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        ListNode dummy = new ListNode(-1);

        ListNode pre = dummy;
        System.out.println(dummy == pre);
        System.out.println(dummy.hashCode() == pre.hashCode());

        pre.next = new ListNode(2);
        System.out.println(dummy == pre);
        System.out.println(dummy.hashCode() == pre.hashCode());

        pre = pre.next;
        System.out.println(dummy == pre);
        System.out.println(dummy.hashCode() == pre.hashCode());

        System.out.println("=============================================================");


        pre = pre.next;
        System.out.println(dummy == pre);
        //System.out.println(dummy.hashCode() == pre.hashCode());

        pre.next = new ListNode(2);
        System.out.println(dummy == pre);
        System.out.println(dummy.hashCode() == pre.hashCode());
    }

}
