package com.example.base.数据结构和算法.书籍.树.平衡二叉树avl;

/**
 * @author jiwei.xue
 * @date 2020/12/29 11:05
 * 左旋——自己变为右孩子的左孩子；右旋——自己变为左孩子的右孩子； 以上口诀+动图=完美
 *
 * https://blog.csdn.net/qq_25343557/article/details/89110319
 * https://blog.csdn.net/qq_37934101/article/details/81160254
 */
public class AvlTree<E extends Comparable<E>> {

    /**
     * 内部类
     */
    private class Node{
        public E e;
        public Node left;
        public Node right;
        public int height;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AvlTree() {
        root = null;
        size = 0;
    }

    /**
     * 获取某一节点的高度
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int balandeFactory = Math.abs(getBalanceFactor(node));
        if (balandeFactory > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }


    /**
     * 查找节点
     *
     * @param e
     * @return
     */
    public Node getNode(E e) {
        Node current = root;

        while (current.e != e) {
            if (e.compareTo(current.e) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }



    /**
     *   LL的意思是向左子树（L）的左孩子（L）中插入新节点后导致不平衡，这种情况下需要右旋操作，而不是说LL的意思是右旋，后面的也是一样。
     * 右旋转
     * 自己变为左孩子的右孩子,自己的左孩子的右孩子变为自己的左孩子
     * @return
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;
        x.right = y;     // 自己变为左孩子的右孩子
        y.left = t3;     // 自己的左孩子的右孩子变为自己的左孩子

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     *  LL的意思是向左子树（L）的左孩子（L）中插入新节点后导致不平衡，这种情况下需要右旋操作，而不是说LL的意思是右旋，后面的也是一样。
     *  左旋转
     *  自己变为右孩子的左孩子,自己的右孩子的左孩子变为自己的右孩子
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;
        x.left = y;
        y.right = t2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    public void add(E e) {
        root = add(root, e);
    }

    public Node add(Node node, E e) {
        if(node == null){
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }

        // 更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && getBalanceFactor(node.left ) > 0) {
            //右旋
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) < 0) {
            // 左旋
            return leftRotate(node);
        }
        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public E remove(E e){
        Node node = getNode(e);
        if(node != null){
            root = remove(root, e);
            return node.e;
        }
        return null;
    }


    private Node remove(Node node, E e){

        if( node == null ) {
            return null;
        }
        Node retNode;
        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            retNode = node;
        } else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            retNode = node;
        } else {   // e.compareTo(node.e) == 0
            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode = rightNode;
            }
            // 待删除节点右子树为空的情况
            else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode = leftNode;
            }else {
                // 待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                successor.right = remove(node.right, successor.e);
                successor.left = node.left;

                node.left = node.right = null;

                retNode = successor;
            }
        }
        if (retNode == null) {
            return null;
        }
        //维护平衡
        //更新height
        retNode.height = 1+Math.max(getHeight(retNode.left),getHeight(retNode.right));
        //计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        if(balanceFactor > 1 && getBalanceFactor(retNode.left)>=0) {
            //右旋LL
            return rightRotate(retNode);
        }
        if(balanceFactor < -1 && getBalanceFactor(retNode.right)<=0) {
            //左旋RR
            return leftRotate(retNode);
        }
        //LR
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
            node.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //RL
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            node.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }

    /**
     * 查找最小节点
     *
     * @return
     */
    public Node minimum(Node node ) {
        Node current = node;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last;
    }


}



