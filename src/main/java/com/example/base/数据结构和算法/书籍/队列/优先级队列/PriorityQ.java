package com.example.base.数据结构和算法.书籍.队列.优先级队列;

/**
 * @author jiwei.xue
 * @date 2021/1/6 14:26
 * <p>
 * 优先级队列
 */
public class PriorityQ {

    private int maxSize;

    private long[] queArray;

    private int nItems;

    public PriorityQ(int size) {
        this.maxSize = size;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j;
        // 如果队列中没有元素，直接插入
        if (nItems == 0) {
            queArray[nItems++] = item;
            // 否则
        } else {
            // 拿插入的元素和队列中元素循环进行比较，从后往前比较
            for (j = nItems - 1; j > 0; j--) {
                // 直到插入的元素小大于循环比较的中元素，即找到插入的位置，将原始位置的元素及以后的元素向后移动一位
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }
            // TODO
            queArray[j + 1] = item;
            nItems++;
        }
    }

    public long remove() {
        return queArray[--nItems];
    }

    public long peekMin() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }
}
