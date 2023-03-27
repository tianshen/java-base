package com.example.base.数据结构和算法.书籍.队列.数组实现队列;

public class QueueX {

    public long[] queueArr;

    private int maxSize;

    private int front;

    private int rear;

    private int nItems;

    public QueueX(int size) {
        queueArr = new long[size];
        maxSize = size;
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * 插入数据
     * @param j
     */
    public void insert(long j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArr[++rear] = j;
        nItems++;
    }

    public long remove() {
        long temp = queueArr[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queueArr[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }

}
