package com.example.base.数据结构和算法.leetcode.二叉树的深度;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
        public int value;

        public TreeNode left;

        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 递归求二叉树的深度
     * 树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现，本文使用递归实现
     * 关键点： 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 广度优先算法  使用队列实现
     * @return
     */
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> temp;
        int res = 0;
        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
            res++;
        }
        return res;
    }


}
