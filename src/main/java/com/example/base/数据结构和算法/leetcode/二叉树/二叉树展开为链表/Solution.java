package com.example.base.数据结构和算法.leetcode.二叉树.二叉树展开为链表;

import com.example.base.数据结构和算法.leetcode.二叉树.Tree;
import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xue
 * @date 2023/4/10 14:05
 */
public class Solution {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(1);
        tree.insert(5);
        tree.insert(7);
        flatten2(tree.root);
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);


        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    // 定义：将以 root 为根的树拉平为链表
    public static void flatten2(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // 利用定义，把左右子树拉平
        flatten2(root.left);
        flatten2(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }


    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    public void flatten03(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            // 前一个节点主要是为了承载这个右边节点可以一直走下去
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }
}
