package com.example.base.数据结构和算法.书籍.数组.面向对象数组编写_高级;

/**
 * @author jiwei.xue
 * @date 2020/12/21 17:43
 */
public class HighArray {

    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    /**
     * find specified value
     * @param searchKey
     * @return
     */
    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * put element into array
     * @param value
     */
    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    /**
     * delete specified value
     * @param value
     * @return
     */
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            // 拿到要删除的元素坐标
            if (a[j] == value) {
                // 跳出循环 不是return
                break;
            }
        }

        //TODO 删除数组指定元素  如果元素的索引==nElems，说明已经大于最后一个元素了，不会再删除的
        if (j == nElems) {
            return false;
        } else {
            //TODO 通过移位的操作，将被删除的元素的后一个元素赋值给前一个元素
            // 这个k的作用，是给个临时变量，主要的作用还是移位操作。
            for (int k = j; k < nElems; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    /**
     * display arr
     */
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.println(a[j] + " ");
        }
        System.out.println("");
    }
}
