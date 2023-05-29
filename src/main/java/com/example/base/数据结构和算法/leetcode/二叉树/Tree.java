package com.example.base.数据结构和算法.leetcode.二叉树;

import java.util.LinkedList;

/**
 * @author xue
 * @date 2023/4/9 20:16
 */
public class Tree {

    public TreeNode root;

    static LinkedList<Integer> preList = new LinkedList();

    static LinkedList<Integer> inList = new LinkedList();

    static LinkedList<Integer> postList = new LinkedList();

    public void preDisplay(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preDisplay(node.left);
        preDisplay(node.right);
    }

    /**
     * 动态规划 分治算法
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
       if (root == null) {
           return 0;
       }
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    /**
     * 遍历的方式求最大深度
     *
     * @param node
     * @return
     */
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 遍历求解
        traverse(node);
        return res;
    }

    public void disPlayTraverse() {
        System.out.println(preList);
        System.out.println(inList);
        System.out.println(postList);
    }


    public int getMaxDepth2(TreeNode node, int res, int dept) {
        if (node == null) {
            return res;
        }
        // 前序遍历位置
        dept++;
        res = Math.max(res, dept);
        getMaxDepth(node.left, res, dept);

        // 中序遍历位置
        getMaxDepth(node.right, res, dept);

        // 后序遍历位置
        return res;
    }



    public int getMaxDepth(TreeNode node, int res, int dept) {
        if (node == null) {
            return res;
        }
        // 前序遍历位置
        dept++;
        res = Math.max(res, dept);
        preList.add(node.val);
        getMaxDepth(node.left, res, dept);

        // 中序遍历位置
        inList.add(node.val);
        getMaxDepth(node.right, res, dept);

        // 后序遍历位置
        // dept--;
        postList.add(node.val);
        return res;
    }


    /**
     * 类似于回溯算法
     * @param node
     */
    int res = 0;
    int dept = 0;

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        // 前序遍历位置
        dept++;
        res = Math.max(res, dept);
        preList.add(node.val);
        traverse(node.left);

        // 中序遍历位置
        inList.add(node.val);
        traverse(node.right);

        // 后序遍历位置
        dept--;
        postList.add(node.val);
    }

    public void insert(int val) {
        TreeNode newNode = new TreeNode();
        newNode.val = val;
        // 如果root为空，直接赋值给root
        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (val < current.val) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
}
