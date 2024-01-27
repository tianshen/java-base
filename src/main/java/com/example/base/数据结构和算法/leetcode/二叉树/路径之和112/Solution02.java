package com.example.base.数据结构和算法.leetcode.二叉树.路径之和112;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;
import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class Solution02 {

    /**
     * 递归的方法
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // 如果根节点为空，直接返回false
        if (root == null) {
            return false;
        }
        // 如果当前节点是叶子节点（即左右子节点都为空），检查路径和是否等于目标值
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // 如果当前节点不是叶子节点，递归地在左子树和右子树中查找路径
        // 路径和等于目标值减去当前节点的值
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     *  深度优先搜索（DFS）递归
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumDfs(TreeNode root, int sum) {
        // 如果根节点为空，直接返回false
        if (root == null) return false;
        // 调用深度优先搜索（DFS）函数，查找是否存在一条从根节点到叶子节点的路径，使得路径上的节点值之和等于给定的目标值
        return dfs(root, sum, root.val);
    }

    /**
     * 深度优先搜索（DFS）递归
     *
     * @param root
     * @param target
     * @param pathSum
     * @return
     */
    private boolean dfs(TreeNode root, int target, int pathSum) {
        // 如果当前节点为空，直接返回false
        if (root == null) return false;
        // 如果路径和等于目标值，并且当前节点是叶子节点（即左右子节点都为空），返回true
        if (pathSum == target && root.left == null && root.right == null) {
            return true;
        }
        // 初始化左右子树的标志位为false
        boolean leftFlag = false, rightFlag = false;
        // 如果左子节点不为空，递归地在左子树中查找路径，路径和等于当前路径和加上左子节点的值
        if (root.left != null) {
            leftFlag = dfs(root.left, target, pathSum + root.left.val);
        }
        // 如果右子节点不为空，递归地在右子树中查找路径，路径和等于当前路径和加上右子节点的值
        if (root.right != null) {
            rightFlag = dfs(root.right, target, pathSum + root.right.val);
        }
        // 如果左子树或右子树中存在满足条件的路径，返回true，否则返回false
        return leftFlag || rightFlag;
    }

    /**
     * 广度优先算法 BFS 队列
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumBfs(TreeNode root, int sum) {
        // 如果根节点为空，直接返回false
        if (root == null) return false;
        // 创建一个队列，用于广度优先搜索（BFS）
        Deque<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        // 将根节点和它的值作为一个对（Pair）添加到队列中
        queue.offer(new Pair<>(root, root.val));
        // 当队列不为空时，继续循环
        while (!queue.isEmpty()) {
            // 从队列中取出一个对
            Pair<TreeNode, Integer> pair = queue.poll();
            // 获取对中的节点和路径和
            TreeNode node = pair.getKey();
            int pathSum = pair.getValue();
            // 如果当前节点是叶子节点（即左右子节点都为空），并且路径和等于目标值，返回true
            if (node.left == null && node.right == null && pathSum == sum) {
                return true;
            }
            // 如果左子节点不为空，将左子节点和当前路径和加上左子节点的值作为一个对添加到队列中
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, pathSum + node.left.val));
            }
            // 如果右子节点不为空，将右子节点和当前路径和加上右子节点的值作为一个对添加到队列中
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, pathSum + node.right.val));
            }
        }
        // 如果遍历完所有节点都没有找到满足条件的路径，返回false
        return false;
    }


    /**
     * 深度优先搜索（DFS）栈
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumDfsStack(TreeNode root, int sum) {
        // 如果根节点为空，直接返回false
        if (root == null) return false;
        // 创建一个栈，用于深度优先搜索（DFS）
        Deque<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        // 将根节点和它的值作为一个对（Pair）压入栈中
        stack.push(new Pair<>(root, root.val));
        // 当栈不为空时，继续循环
        while (!stack.isEmpty()) {
            // 从栈中弹出一个对
            Pair<TreeNode, Integer> pair = stack.pop();
            // 获取对中的节点和路径和
            TreeNode node = pair.getKey();
            int pathSum = pair.getValue();
            // 如果当前节点是叶子节点（即左右子节点都为空），并且路径和等于目标值，返回true
            if (node.left == null && node.right == null && pathSum == sum) {
                return true;
            }
            // 如果左子节点不为空，将左子节点和当前路径和加上左子节点的值作为一个对压入栈中
            if (node.left != null) {
                stack.push(new Pair<>(node.left, pathSum + node.left.val));
            }
            // 如果右子节点不为空，将右子节点和当前路径和加上右子节点的值作为一个对压入栈中
            if (node.right != null) {
                stack.push(new Pair<>(node.right, pathSum + node.right.val));
            }
        }
        // 如果遍历完所有节点都没有找到满足条件的路径，返回false
        return false;
    }
}