package com.example.base.数据结构和算法.leetcode.二叉树.最小深度;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

/**
 * @author xue
 * @date 2023/4/10 11:59
 */
public class Solution {

    int depth = 0;
    int res = Integer.MAX_VALUE;
    public void minDepth(TreeNode root) {
        if (root == null) {
            return;
        }

    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        // 求最小的时候 要判断是否是叶子节点
        if (root.left == null && root.right == null) {
            res = Math.min(depth, res);
        }
        traverse(root.left);
        traverse(root.right);
        // 回溯
        depth--;
    }
}
