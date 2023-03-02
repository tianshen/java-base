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
            if (a[j] == value) {
                break;
            }
        }

        //TODO 删除数组指定元素
        if (j == nElems) {
            return false;
        } else {
            //TODO 通过移位的操作，将被删除的元素的后一个元素赋值给前一个元素
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
