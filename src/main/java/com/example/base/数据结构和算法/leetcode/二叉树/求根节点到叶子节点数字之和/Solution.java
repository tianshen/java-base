package com.example.base.数据结构和算法.leetcode.二叉树.求根节点到叶子节点数字之和;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

/**
 * 求根节点到叶子节点数字之和
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i){
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }

}
