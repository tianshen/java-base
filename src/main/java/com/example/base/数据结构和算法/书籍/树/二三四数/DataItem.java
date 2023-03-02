package com.example.base.数据结构和算法.书籍.树.二三四数;

/**
 * @author jiwei.xue
 * @date 2021/1/4 10:48
 */
public class DataItem {

    public long dData;

    public DataItem(long dd) {
        this.dData = dd;
    }

    public void displayItem() {
        System.out.println("/" + dData);
    }
}
