package com.example.base.数据结构和算法.leetcode.二叉树.二叉搜索树的最小绝对值差;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

public class Solution {

    /**
     * 使用中序遍历
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return res;

    }

    TreeNode pre = null;
    int res = Integer.MAX_VALUE;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        // 给前一个节点赋值
        pre = root;

        traverse(root.right);
    }
}
