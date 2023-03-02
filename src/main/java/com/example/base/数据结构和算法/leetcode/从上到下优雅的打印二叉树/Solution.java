package com.example.base.数据结构和算法.leetcode.从上到下优雅的打印二叉树;

import java.util.*;

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
     * 层序遍历
     *
     * @param root
     * @return
     */
    public static int[] levelOrder(TreeNode root) {
        // 判断root是否为空
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.value);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
