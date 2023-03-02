package com.example.base.数据结构和算法.书籍.图;

/**
 * @author jiwei.xue
 * @date 2021/1/8 16:37
 */
public class StackX {

    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j) {
        st[++top] = j;
    }

    public int pop() {
        return st[top--];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
