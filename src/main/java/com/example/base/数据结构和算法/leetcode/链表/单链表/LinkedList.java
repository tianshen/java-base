package com.example.base.数据结构和算法.leetcode.链表.单链表;

/**
* 链表
 */
public class LinkedList {
    int length = 0; // 链表长度，非必须，可不加
    Node head = new Node(0); // 哨兵结点

    /**
     * 尾插
     * @param val
     */
    public void addNode(int val) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new Node(val);
        length++;
    }

    // 头插法
    public void headInsert(int val) {
        // 1.构造新结点
        Node newNode = new Node(val);
        // 2.新结点指向头结点之后的结点
        newNode.next = head.next;
        // 3.头结点指向新结点
        head.next = newNode;
        length++;
    }

    public void printList() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.data);
        }
    }


    /**
     *  递归反转链表
     * @param node
     */
    public Node invertLinkedListRecursion(Node node) {
        if (node.next == null) {
            return node;
        }
        Node newNode = invertLinkedListRecursion(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }

    /**
     * 顺序翻转链表
     * @param node
     * @return
     */
    public Node invertLinkedList(Node node) {
        Node pre = node;
        Node cur = pre.next;
        pre.next = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public Node iterationInvertLinkedList(int fromIndex, int toIndex, Node node) throws Exception {

        Node fromPre = null;            // from-1结点
        Node from = null;               // from 结点
        Node to = null;                 // to 结点
        Node toNext = null;             // to+1 结点

        // 步骤 1：找到  from-1, from, to,  to+1 这四个结点
        Node tmp = node;
        int curIndex = 1;      // 头结点的index为1
        while (tmp != null) {
            if (curIndex == fromIndex-1) {
                fromPre = tmp;
            } else if (curIndex == fromIndex) {
                from = tmp;
            } else if (curIndex == toIndex) {
                to = tmp;
            } else if (curIndex == toIndex+1) {
                toNext = tmp;
            }
            tmp = tmp.next;
            curIndex++;
        }

        if (from == null || to == null) {
            // from 或 to 都超过尾结点不翻转
            throw new Exception("不符合条件");
        }

        // 步骤2：以下使用循环迭代法翻转从 from 到 to 的结点
        Node pre = from;
        Node cur = pre.next;
        while (cur != toNext) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 步骤3：将 from-1 节点指向 to 结点（如果从 head 的后继结点开始翻转，则需要重新设置 head 的后继结点），将 from 结点指向 to + 1 结点
        if (fromPre != null) {
            fromPre.next = to;
        }
        from.next = toNext;
        return fromPre;
    }

    public Node findMiddleNode() {
        Node tmp = head.next;
        int middleLength = length / 2;
        while (middleLength > 0) {
            tmp = tmp.next;
            middleLength--;
        }
        return tmp;
    }

    public Node findMiddleNodeWithSlowFastPointer() {
        Node slow = head.next;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            // 快指针走两步
            fast = fast.next.next;
            // 慢指针走一步
            slow = slow.next;
        }
        // 此时的 slow 结点即为哨兵结点
        return slow;
    }

    public Node findKthToTail(int k) throws Exception {
        Node slow = head.next;
        Node fast = head.next;

        // 快指针先移到第k个结点
        int tmpK = k - 1;
        while (tmpK > 0 && fast != null) {
            fast = fast.next;
            tmpK--;
        }
        // 临界条件：k大于链表长度
        if (fast == null) {
            throw new Exception("K结点不存在异常");
        }
        // slow 和 fast 同时往后移，直到 fast 走到尾结点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}