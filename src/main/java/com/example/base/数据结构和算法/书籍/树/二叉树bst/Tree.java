package com.example.base.数据结构和算法.书籍.树.二叉树bst;

/**
 * @author jiwei.xue
 * @date 2020/12/28 10:37
 */
public class Tree {

    private Node root;

    /**
     * 查找节点的时间取决于这个节点所在的层数 O(logN)
     *
     * @param key
     * @return
     */
    public Node find(int key) {
        Node current = root;

        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }


    /**
     * 插入新节点
     *
     * @param id
     * @param dd
     */
    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.fData = dd;
        // 如果root为空，直接赋值给root
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }


    }

    /**
     * 删除节点
     *
     * @param key
     */
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        // 先判断删除的节点的是左子节点还是右子节点
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false;
            }
        }

        // 第一种情况 删除的节点为叶子节点  当前节点的左子节点和右子节点都是空
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        // 第二种情况 删除的节点有一个左子节点
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            // 第三种情况 删除的节点有一个右子节点
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            // 删除的节点有两个子节点
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    /**
     *
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;

        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch(traverseType) {
            case 1:
                System.out.println("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.println("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.println("\nposorder traversal: ");
                posOrder(root);
                break;
        }
        System.out.println();
    }

    /**
     * 中序遍历
     */
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    /**
     * 前序遍历
     *
     * @param localRoot
     */
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    /**
     * 后续遍历
     *
     * @param localRoot
     */
    private void posOrder(Node localRoot) {
        if (localRoot != null) {
            posOrder(localRoot.leftChild);
            posOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    /**
     * 查找最小节点
     *
     * @return
     */
    public Node minimun() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    /**
     * 查找最大节点
     *
     * @return
     */
    public Node maximun() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }
}
