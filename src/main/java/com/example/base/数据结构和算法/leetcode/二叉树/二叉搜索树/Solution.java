package com.example.base.数据结构和算法.leetcode.二叉树.二叉搜索树;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

/**
 * @author xue
 * @date 2023/4/10 23:38
 */
public class Solution {

    /**
     * 二叉搜索树查找元素
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode searchBts(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBts(root.left, val);
        } else {
            return searchBts(root.right, val);
        }

    }

    /**
     * 二叉搜索树插入元素
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertBts(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            return root.left = insertBts(root.left, val);
        } else {
            return root.right = insertBts(root.right, val);
        }
    }

    /**
     * 删除指定节点  这个不对
     *
     * @param root
     * @param val
     * @return
     */
//    public static TreeNode deleteBts(TreeNode root, int val) {
//        if (root == null) {
//            return null;
//        }
//
//        if (root.val == val) {
//            return null;
//        }
//
//        if (val < root.val) {
//            return root.left = deleteBts(root.left, val);
//        } else {
//            return root.right = deleteBts(root.right, val);
//        }
//    }

    /**
     * 验证是否是一个二叉树搜索树
     *
     * @param root
     * @param max
     * @param min
     * @return
     */
    public static boolean isValidBts(TreeNode root, TreeNode max, TreeNode min) {
        // 根节点为null
        if (root == null) {
            return true;
        }

        // 根节点小于右子树
        if (max != null && root.val > max.val) {
            return false;
        }
        // 根节点大于左子树
        if (min != null && root.val < min.val) {
            return false;
        }
        return isValidBts(root.left, root, null) || isValidBts(root.right, root, null);
    }

    /**
     * 构建二叉搜索树
     *
     * @param preList
     * @param start
     * @param end
     * @return
     */
    public static TreeNode buildTreeNode(int[] preList, int start, int end) {
        if (start > end) {
            return null;
        }

        // 第一个节点是根节点
        int rootVal = preList[start];
        TreeNode root = new TreeNode(rootVal);
        // 确定左子树的索引
        int p = start + 1;
        while (p <= end && preList[p] < rootVal) {
            p++;
        }
        root.left = buildTreeNode(preList, start + 1, p - 1);
        root.right = buildTreeNode(preList, p, end);
        return root;
    }

}
