package com.example.base.数据结构和算法.书籍.数组.面向对象数组编写_低级;

/**
 * @author jiwei.xue
 * @date 2020/12/21 17:28
 */
public class LowArray {

    private long[] a;

    /**
     * 构造函数
     */
    public LowArray(int size) {
        a = new long[size];
    }

    /**
     * set方法 添加元素
     * @param index
     * @param value
     */
    public void setElem(int index, long value) {
        a[index] = value;
    }

    /**
     * get方法 查找元素
     * @param index
     * @return
     */
    public long getElem(int index) {
        return a[index];
    }
}
