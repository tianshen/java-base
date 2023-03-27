package com.example.base.数据结构和算法.书籍.排序.高级排序;

/**
 * 归并排序
 * 分3步
 * 1、递归拆分
 * 2、合并有序列表
 *
 *
 */
public class MergeSortAppX {

    public static long[] theArray = {33, 66, 22, 77, 55, 11, 99, 44, 88};

    public static void main(String[] args) {
        long[] workSpace = new long[9];
        recMergeSort(workSpace, 0, theArray.length - 1);
        for (int j = 0; j < theArray.length; j++) {
            System.out.println(theArray[j] + " ");
        }
        System.out.println("");
    }

    private static void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);

        }

    }


}
