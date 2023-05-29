package com.example.base.数据结构和算法.leetcode.二叉树.路径之和112;

import com.example.base.数据结构和算法.leetcode.二叉树.Tree;
import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

/**
 * @author xue
 * @date 2023/4/9 22:39
 */
public class Solution {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
//        tree.insert(1);
//        tree.insert(6);
//        tree.insert(5);
//        tree.insert(4);
        System.out.println(new Solution().hasPathSum(tree.root, 10));
        // new Solution().traverse(tree.root);
        System.out.println(found);
    }


    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        return traverse(root, 0, target);
    }

    static boolean found = false;
    int sum = 0;
    int target = 10;
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                found = true;
            }
        }
        traverse(root.left);
        traverse(root.right);
        sum -= root.val;
    }



    public boolean traverse(TreeNode root, int curSum, int target) {
        if (root == null) {
            return true;
        }
        // 前序遍历
        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (curSum == target) {
                return true;
            }
        }
        System.out.println("pre===" + curSum);
        boolean traverse = traverse(root.left, curSum, target);
        if (traverse) {
            return true;
        }
        System.out.println("in===" + curSum);
        boolean traverse1 = traverse(root.right, curSum, target);
        if (traverse1) {
            return true;
        }
        // 后序遍历
        //curSum -= root.val;
        System.out.println("post===" + curSum);

        return false;
    }


    public boolean haspathsum(TreeNode root, int targetsum) {
        if (root == null) {
            return false;
        }
        targetsum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetsum == 0;
        }
        if (root.left != null) {
            boolean left = haspathsum(root.left, targetsum);
            if (left) {// 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = haspathsum(root.right, targetsum);
            if (right) {// 已经找到
                return true;
            }
        }
        return false;
    }


    /**
     * 分解思路实现
     *
     * @param root
     * @param target
     * @return
     */
    public boolean hasPathSum01(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == target;
        }
        return hasPathSum01(root.left, target - root.val) || hasPathSum01(root.right, target - root.val);
    }

}
