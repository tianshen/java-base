package com.example.base.数据结构和算法.书籍.排序.高级排序;

/**
 * 归并排序
 */
public class MergeSortApp {

    public static long[] theArray = {33, 66, 22, 77, 55, 11, 99, 44, 88};

    public static void main(String[] args) {
        long[] workSpace = new long[9];
        recMergeSort(workSpace, 0, workSpace.length - 1);
        for (int j = 0; j < theArray.length; j++) {
            System.out.println(theArray[j] + " ");
        }
        System.out.println("");
    }


    private static void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        // 判断临界值
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }


    private static void merge(long[] workSpace, int lowPtr, int highptr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highptr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highptr <= upperBound) {
            if (theArray[lowPtr] < theArray[highptr]) {
                workSpace[j++] = theArray[lowPtr++];
            } else {
                workSpace[j++] = theArray[highptr++];
            }
        }

        while (lowPtr <= mid) {
            workSpace[j++] = theArray[lowPtr++];
        }

        while (highptr <= upperBound) {
            workSpace[j++] = theArray[highptr++];
        }

        for (j = 0; j < n; j++) {
            theArray[lowerBound + j] = workSpace[j];
        }

    }
}
