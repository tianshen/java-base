package com.example.base.数据结构和算法.书籍.排序.高级排序;

public class QuickSortApp {

    public static long[] theArray = new long[]{77, 66, 22, 88, 55, 11, 99, 33, 44};

    public static void main(String[] args) {
        recQuickSort(0, theArray.length - 1);
        for (int j = 0; j < theArray.length; j++) {
            System.out.println(theArray[j] + " ");
        }
        System.out.println("");

    }


    public static void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            long pivot = theArray[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public static int partitionIt(int left, int right, long pivot) {
        int leftPrt = left - 1;
        int rightPrt = right;
        while (true) {
            while (theArray[++leftPrt] < pivot) {

            }
            while (rightPrt > 0 && theArray[--rightPrt] > pivot) {

            }
            if (leftPrt >= rightPrt) {
                break;
            } else {
                swap(leftPrt, rightPrt);
            }
        }
        swap(leftPrt, right);
        return leftPrt;
    }

    public static void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
