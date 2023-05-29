package com.example.base.数据结构和算法.leetcode.链表.链表142_环形链表2;

import com.example.base.数据结构和算法.leetcode.链表.ListNode;
import com.example.base.数据结构和算法.leetcode.链表.ListNodeUtil;
import org.assertj.core.util.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xue
 * @date 2023/4/8 15:35
 * 环形链表判断是否有环
 * https://leetcode.cn/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 */
public class Solution {

    public static ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> nodeSet = Sets.newHashSet();
        while (pos != null) {
            if (nodeSet.contains(pos)) {
                return pos;
            } else {
                nodeSet.add(pos);
                pos = pos.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 4, 5, 4});
        ListNode node = detectCycle(head);
        ListNodeUtil.display(node);
    }
}
