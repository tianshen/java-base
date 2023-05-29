package com.example.base.数据结构和算法.leetcode.二叉树.两个二叉树是否相同;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

/**
 * @author xue
 * @date 2023/4/10 13:18
 */
public class Solution {

    /**
     * 分解的思维
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) || isSame(p.right, q.right);
    }
}
