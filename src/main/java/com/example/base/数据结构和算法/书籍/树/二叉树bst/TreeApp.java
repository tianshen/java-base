package com.example.base.数据结构和算法.书籍.树.二叉树bst;

/**
 * @author jiwei.xue
 * @date 2020/12/28 10:40
 */
public class TreeApp {

    public static void main(String[] args) {

        Tree theTree = new Tree();

        theTree.insert(54, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(13, 1.9);
        theTree.insert(19, 1.9);
        theTree.insert(1, 1.9);
        theTree.insert(67, 1.9);
        theTree.insert(0, 1.9);
        theTree.insert(12, 1.9);

        theTree.traverse(1);

        Node found = theTree.find(25);
//        if (found != null) {
//            System.out.println("found the node with 25");
//        } else {
//            System.out.println("can not find node with key 25");
//        }

    }
}
