package com.example.base.数据结构和算法.书籍.树.二叉数测试;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    private Node root;

    /**
     * 插入新节点
     *
     * @param value
     */
    public void insert(long value) {
        Node newNode = new Node();
        newNode.setValue(value);
        // 如果root为空，直接赋值给root
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (value < current.getValue()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }


    // 遍历
    public List<List<Long>> levelOrder(Node root) {
        List<List<Long>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Long> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                Node node = queue.poll();
                level.add(node.getValue());
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            ret.add(level);
        }

        return ret;
    }

    public List<Long> traverseLevelOrder() {
        if (root == null) {
            return Lists.newArrayList();
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        List<Long> values = Lists.newArrayList();
        values.add(root.getValue());
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            if (node.getLeft() != null) {
                values.add(node.getLeft().getValue());
                nodes.add(node.getLeft());
            }
            if (node.getRight()!= null) {
                values.add(node.getRight().getValue());
                nodes.add(node.getRight());
            }
        }
        return values;
    }
}
