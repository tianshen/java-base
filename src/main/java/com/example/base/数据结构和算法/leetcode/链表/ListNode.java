package com.example.base.数据结构和算法.leetcode.链表;

import java.util.Objects;

/**
 * @author xue
 * @date 2023/4/8 9:16
 */
public class ListNode {

    public int intValue;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.intValue = val;
    }

    public ListNode(int val, ListNode next) {
        this.intValue = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode node = (ListNode) o;
        return intValue == node.intValue && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intValue, next);
    }
}
