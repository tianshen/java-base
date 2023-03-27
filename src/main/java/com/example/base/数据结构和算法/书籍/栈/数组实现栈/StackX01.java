package com.example.base.数据结构和算法.书籍.栈.数组实现栈;

/**
 * @author jiwei.xue
 * @date 2020/10/30 16:07
 */
public class StackX01 {

    private long[] stackArr;

    private int maxSize;

    private int top;

    public StackX01(int size) {
        this.maxSize = size;
        stackArr = new long[maxSize];
        top = -1;
    }

    /**
     * 入栈
     * @param x
     */
    public void push(long x) {
        stackArr[++top] = x;
    }

    /**
     * 出栈
     * @return
     */
    public long pop() {
        return stackArr[top--];
    }

    /**
     * 查看栈元素
     * @return
     */
    public long peek() {
        return stackArr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize;
    }
}
