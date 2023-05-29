package com.example.base.数据结构和算法.leetcode.二叉树.二叉树迭代;

import com.example.base.数据结构和算法.leetcode.二叉树.Tree;
import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

import java.util.Stack;

/**
 * @author xue
 * @date 2023/4/10 16:05
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
        traverse(tree.root);

    }

    private static Stack<TreeNode> stack = new Stack<>();

    /**
     * 将左边的元素都压入栈中
     *
     * @param p
     */
    public static void pushBranch(TreeNode p) {
        while (p != null) {
            /* 前序遍历的代码位置 */
            stack.push(p);
            p = p.left;
        }
    }

    public static void traverse(TreeNode root) {
        // 指向上一次遍历完的子数的跟节点
        TreeNode visited = new TreeNode(-1);

        // 开始遍历整棵树
        pushBranch(root);

        while (!stack.isEmpty()) {

            TreeNode p = stack.peek();
            // p的左子树被遍历完了，且右子树没有被遍历过
            if ((p.left == null || p.left == visited) && p.right != visited) {
                // 去遍历右子树
                pushBranch(p.right);
            }

            // p的右子树被遍历完了
            if (p.right == null || p.right == visited) {
                // 以p为跟的子树遍历完了，出栈， visited指针指向p
                visited = stack.pop();
            }
        }

    }
}
