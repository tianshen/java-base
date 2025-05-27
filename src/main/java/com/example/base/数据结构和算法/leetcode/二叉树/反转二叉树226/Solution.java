package com.example.base.数据结构和算法.leetcode.二叉树.反转二叉树226;

import com.example.base.数据结构和算法.leetcode.二叉树.Tree;
import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

/**
 * @author xue
 * @date 2023/4/10 11:33
 */
public class Solution {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        TreeNode treeNode = new Solution().invertTree(tree.root);
        tree.preDisplay(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        return root;
    }

    /**
     * 反转二叉树
     *
     * @param root
     */
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverse(root.left);
        traverse(root.right);
    }








    public void traverse01(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverse01(root.left);
        traverse01(root.right);
    }
}
