package com.example.base.数据结构和算法.leetcode.二叉树.二叉搜索树种第k小的元素;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

public class Solution {

    public int findKMinNode(TreeNode root) {
        traverse(root, 2);
        return res;
    }

    int res = 0;
    int rank = 0;
    public void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);
        // 排名
        rank++;
        // 找到元素返回
        if (rank == k) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }

        traverse(root.right, k);

    }
}
