package com.example.base.数据结构和算法.leetcode.二叉树.最大深度;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

/**
 * 求最大深度
 */
public class Solution {

    int depth = 0;
    int res = 0;

    void maxDepth(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root);
    }

    void traverse(TreeNode root) {

        // 前序
        depth++;
        res = Math.max(depth, res);
        traverse(root.left);

        traverse(root.right);
        // 后序
        depth--;
    }
}
