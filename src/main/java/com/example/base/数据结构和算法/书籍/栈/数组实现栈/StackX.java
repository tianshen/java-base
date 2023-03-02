package com.example.base.数据结构和算法.书籍.栈.数组实现栈;

/**
 * @author jiwei.xue
 * @date 2020/10/30 16:07
 */
public class StackX {

    private int maxSize;

    private long[] stackArray;

    private int top;

    public StackX(int size) {
        this.maxSize = size;
        stackArray = new long[maxSize];
        top = -1;
    }

    /**
     * 入栈
     * @param j
     */
    public void push(long j) {
        stackArray[++top] = j;
    }

    /**
     * 出栈
     * @return
     */
    public long pop() {
        return stackArray[top--];
    }

    /**
     * 查看栈元素
     * @return
     */
    public long peek() {
        return stackArray[top];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }
}
