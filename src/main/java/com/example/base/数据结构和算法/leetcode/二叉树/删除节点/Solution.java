package com.example.base.数据结构和算法.leetcode.二叉树.删除节点;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

/**
 * @author xue
 * @date 2023/4/10 20:39
 */
public class Solution {

    /**
     * 删除叶子节点
     * @param root
     * @return
     */
    public static TreeNode removeLeafNodes (TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        return root;
    }

    /**
     *  删除叶子节点是target的节点
     * @param root
     * @param target
     * @return
     */
    public static TreeNode removeLeafNodesWithTarget (TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        root.left = removeLeafNodesWithTarget(root.left, target);
        root.right = removeLeafNodesWithTarget(root.right, target);
        return root;
    }

    /**
     * 删除叶子节点是target的所有的叶子节点
     * 后序遍历的时候可以自下向上的判断 可能一个叶子节点删除了  但是他的根节点又变成了叶子节点  这个时候还要把这个叶子节点删了
     * @param root
     * @param target
     * @return
     */
    public static TreeNode removeLeafNodesWithTargetAll (TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodesWithTargetAll(root.left, target);
        root.right = removeLeafNodesWithTargetAll(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
