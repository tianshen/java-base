package com.example.base.数据结构和算法.书籍.树.二叉数测试;

import java.util.List;

public class TestApp {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.insert(60L);
        treeNode.insert(10L);
        treeNode.insert(20L);
        treeNode.insert(30L);
        treeNode.insert(40L);
        treeNode.insert(50L);
        treeNode.insert(70L);
        treeNode.insert(80L);
        treeNode.insert(90L);
        List<Long> values = treeNode.traverseLevelOrder();
        for (Long value : values) {
            System.out.println(value + " ");
        }
    }
}
