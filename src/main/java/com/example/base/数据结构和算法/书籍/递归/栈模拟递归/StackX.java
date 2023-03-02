package com.example.base.数据结构和算法.书籍.递归.栈模拟递归;

/**
 * @author jiwei.xue
 * @date 2020/12/23 10:28
 */
public class StackX {

    private int maxSize;
    private Params[] stackArray;
    private int top;

    public StackX(int size) {
        this.maxSize = size;
        this.stackArray = new Params[maxSize];
        top = -1;
    }

    /**
     * 入栈
     *
     * @param p
     */
    public void push(Params p) {
        stackArray[++top] = p;
    }

    /**
     * 出栈
     *
     * @return
     */
    public Params pop() {
        return stackArray[top--];
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public Params peek() {
        return stackArray[top];
    }
}
