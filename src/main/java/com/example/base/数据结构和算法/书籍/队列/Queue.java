package com.example.base.数据结构和算法.书籍.队列;

public class Queue {

    private int maxSize;

    private long[] queArray;

    /**
     * 队列头部
     */
    private int front;

    /**
     * 队列尾部
     */
    private int rear;

    private int nItems;

    public Queue(int s) {
        this.maxSize = s;
        queArray = new long[maxSize];
        // 队列头部
        front = 0;
        // 队列尾部
        rear = -1;
        nItems = 0;
    }

    /**
     * 向队列中插入数据  put item at rear of queue
     * 从队列的尾部插入数据
     * 队列插入数据的时候都是从尾部开始插入的
     * @param j
     */
    public void insert(long j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    /**
     * 从队列中移除数据 take item from front of queue
     * 从队列的头部移除插入数据
     * 队列移除数据的时候都是从头部开始移除的
     * @return
     */
    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    /**
     * 查看队列中的数据
     * @return
     */
    public long peekFront() {
        return queArray[front];
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return nItems == 0;
    }

    /**
     * 队列是否已满
     * @return
     */
    public boolean isFull() {
        return nItems == maxSize;
    }

    /**
     * 队列中数据的个数
     * @return
     */
    public int size() {
        return nItems;
    }

}
