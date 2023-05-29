package com.example.base.数据结构和算法.leetcode.栈.最小栈;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /**
     * 初始化栈
     */
    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * 添加元素
     *
     * @param x
     */
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    /**
     * 弹出元素
     */
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
