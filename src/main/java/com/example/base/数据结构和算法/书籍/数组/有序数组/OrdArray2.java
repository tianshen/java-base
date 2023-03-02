package com.example.base.数据结构和算法.书籍.数组.有序数组;

public class OrdArray2 {

    private long[] arr;

    private int nElems;

    private OrdArray2(int max) {
        arr = new long[max];
        nElems = 0;
    }

    private long find(long searchKey) {
        int lowBound = 0;
        int highBound = nElems - 1;
        int curBound = (lowBound + highBound) / 2;
        while (true) {
            if (arr[curBound] == searchKey) {
                return arr[curBound];
            } else if (lowBound > highBound) {
                return nElems;
            } else {
                if (searchKey < arr[curBound]) {
                    highBound = curBound - 1;
                } else {
                    lowBound = curBound + 1;
                }
            }
        }
    }
}
