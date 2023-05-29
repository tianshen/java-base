package com.example.base.数据结构和算法.leetcode.链表.单链表;

/**
 * @author xue
 * @date 2023/4/7 14:50
 */
public class LinkedListTest {

    public static void main(String[] args) throws Exception {
        //反转链表递归方式();
        // 反转链表正常方式();
        //反转链表正常迭代方式();
        找中间节点();

    }



    public static LinkedList testHead(int[] arr) {
        LinkedList linkedList = new LinkedList();
        // 头插法构造链表
        for (int i = 0; i < arr.length; i++) {
            linkedList.headInsert(arr[i]);
        }
        return linkedList;
        // 打印链表,将打印 4-->3-->2-->1
        // linkedList.printList();
        // System.out.println("-------------------------head insert---------------------------");
    }

    public static LinkedList testTail(int[] arr) {
        LinkedList linkedList = new LinkedList();
        // 头插法构造链表
        for (int i = 0; i < arr.length; i++) {
            linkedList.addNode(arr[i]);
        }
        return linkedList;
        // 打印链表,将打印 4-->3-->2-->1
        // linkedList.printList();
        // System.out.println("-----------------------tail insert-----------------------------");
    }


    private static void 反转链表递归方式() {
        // --------------------------反转链表 递归方式----------------------------
        int[] arr = {1,2,3,4};
        LinkedList linkedList = testTail(arr);
        Node node = linkedList.invertLinkedListRecursion(linkedList.head.next);
        linkedList.head.next = node;
        linkedList.printList();
        // ------------------------------------------------------
    }



    private static void 反转链表正常方式() {
        // --------------------------反转链表 递归方式----------------------------
        int[] arr = {1,2,3,4};
        LinkedList linkedList = testTail(arr);
        Node node = linkedList.invertLinkedList(linkedList.head.next);
        linkedList.head.next = node;
        linkedList.printList();
        // ------------------------------------------------------
    }

    private static void 反转链表正常迭代方式() throws Exception {
        // --------------------------反转链表 递归方式----------------------------
        int[] arr = {1,2,3,4,5,6,7,8};
        LinkedList linkedList = testTail(arr);
        Node node = linkedList.iterationInvertLinkedList(2, 4, linkedList.head.next);
        linkedList.head.next = node;
        linkedList.printList();
        // ------------------------------------------------------
    }

    private static void 找中间节点() throws Exception {
        // --------------------------反转链表 递归方式----------------------------
        int[] arr = {1,2,3,4,5,6,7,8};
        LinkedList linkedList = testTail(arr);
        // Node node = linkedList.findMiddleNode();
        Node node = linkedList.findMiddleNodeWithSlowFastPointer();
        System.out.println(node.data);
        // ------------------------------------------------------
    }

}
