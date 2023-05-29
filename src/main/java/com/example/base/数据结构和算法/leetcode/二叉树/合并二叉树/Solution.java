package com.example.base.数据结构和算法.leetcode.二叉树.合并二叉树;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

/**
 * @author xue
 * @date 2023/4/10 21:31
 */
public class Solution {

    /**
     * 合并两个二叉树 主要考察递归中的返回值的运用
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTreeNode(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        // todo 关键点  递归的修改一个二叉树
        root1.left = mergeTreeNode(root1.left, root2.left);
        // todo 关键点
        root1.right = mergeTreeNode(root1.right, root2.right);

        return root1;
    }
}
