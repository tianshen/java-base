package com.example.base.数据结构和算法.leetcode.二叉树.层序遍历;

import com.example.base.数据结构和算法.leetcode.二叉树.Tree;
import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xue
 * @date 2023/4/10 17:21
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
        // List<List<Integer>> lists = levelOrder(tree.root);
        // System.out.println(lists);
        int maxLevelSum = maxLevelSum(tree.root);
        System.out.println(maxLevelSum);

    }

    public ArrayList<ArrayList<Integer>> levelOrderTest(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList();
            for (int i = 0; i <= size; ++i) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }

        return res;
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    /**
     * 从上向下，从左到右 遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }


        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while 控制的是层数
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            // for 控制的是每一层的元素
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.addLast(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.addLast(level);
        }
        return res;
    }

    /**
     * 从下向上，从左到右 遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderButton(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while 控制的是层数
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            // for 控制的是每一层的元素
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.addLast(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.addFirst(level);
        }
        return res;
    }

    /**
     * 从下向上，从右到左 遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderButtonRightToLeft(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while 控制的是层数
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            // for 控制的是每一层的元素
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.addLast(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.addFirst(level);
        }
        return res;
    }

    /**
     * 层序遍历算最小深度
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderDepth(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while 控制的是层数
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            // for 控制的是每一层的元素
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return res;
                }
                level.addLast(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
            res.addLast(level);
        }
        return res;
    }

    public static int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        int maxSum = Integer.MIN_VALUE;
        int index = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                levelSum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if (levelSum > maxSum) {
                index = depth;
                maxSum = levelSum;
            }
            depth++;
        }
        return index;
    }

}
