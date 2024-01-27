package com.example.base.数据结构和算法.leetcode.二叉树.n叉数的遍历;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNodeN;

/**
 * @author xue
 * @date 2023/4/10 12:11
 */
public class Solution {

    /**
     * 多叉树的遍历过程
     * @param root
     */
    public void traverse(TreeNodeN root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置

        for (TreeNodeN node : root.children) {
            traverse(node);
        }

        // 后序遍历位置
    }
}

