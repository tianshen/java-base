package com.example.base.数据结构和算法.书籍.堆;

/**
 * @author jiwei.xue
 * @date 2021/1/6 15:48
 */
public class Node {

    private int iData;

    public Node(int key) {
        this.iData = key;
    }

    public int getKey() {
        return iData;
    }

    public void setKey(int iData) {
        this.iData = iData;
    }
}
