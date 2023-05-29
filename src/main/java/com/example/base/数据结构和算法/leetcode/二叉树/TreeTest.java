package com.example.base.数据结构和算法.leetcode.二叉树;

/**
 * @author xue
 * @date 2023/4/9 19:35
 */
public class TreeTest {

    public static void main(String[] args) {

        // 生成一个二叉树
        Tree tree = new Tree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        //tree.traverse(tree.root);
        //System.out.println(tree.res);
        int maxDepth = tree.getMaxDepth(tree.root, 0, 0);
        System.out.println(maxDepth);
        tree.disPlayTraverse();



    }
}
