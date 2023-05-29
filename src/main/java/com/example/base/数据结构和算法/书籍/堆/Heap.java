package com.example.base.数据结构和算法.书籍.堆;

import com.example.base.数据结构和算法.leetcode.二叉树.TreeNode;
import lombok.Data;

/**
 * @author jiwei.xue
 * @date 2021/1/6 15:50
 * 大顶堆
 */
@Data
public class Heap {

    private Node[] heapArray;

    private int maxSize;

    private int currentSize;

    public Heap(int mx) {
        this.maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * 插入节点
     *
     * @param key
     * @return
     */
    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        } else {
            Node newNode = new Node(key);
            heapArray[currentSize] = newNode;
            // 向上筛选
            trickleUp(currentSize++);
            return true;
        }
    }

    /**
     * 向上筛选
     *
     * @param index
     */
    public void trickleUp(int index) {
        // 求出父节点的坐标
        int parent = (index - 1) / 2;
        // 将新增的节点定义一个临时变量
        Node bottom = heapArray[index];
        // 向上筛选,拿新增节点和他的父节点进行比较,如果父节点小于新增节点的话
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            // 新增节点和父节点换位置
            heapArray[index] = heapArray[parent];
            // 更新索引
            index = parent;
            // 求新的父节点的索引
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    /**
     * 优先 删除节点
     *
     * @return
     */
    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    /**
     * 向下筛选
     *
     * @param index
     */
    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {    // 至少有一个子节点
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    /**
     * 替换值
     *
     * @return
     */
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (oldValue < newValue) {
            // 向上筛选
            trickleUp(index);
        } else {
            // 向下筛选
            trickleDown(index);
        }
        return true;
    }
}
