package com.example.base.数据结构和算法.书籍.排序.高级排序;

public class QuickSort02App {

    public static long[] theArray = new long[]{33, 66, 22, 77, 55, 11, 99, 44, 88};

    public static void main(String[] args) {
        recQuickSort(0, theArray.length - 1);
        for (int j = 0; j < theArray.length; j++) {
            System.out.println(theArray[j] + " ");
        }
        System.out.println("");

    }

    public static void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3) {
            manualSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    /**
     * 划分
     */
    public static int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            while(theArray[++leftPtr] < pivot) {

            }
            while(theArray[--rightPtr] > pivot) {

            }
            if (leftPtr > rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    public static long medianOf3(int left, int right) {
        int center = (left + right) / 2;
        if (theArray[left] > theArray[center]) {
            swap(left, center);
        }
        if (theArray[left] > theArray[right]) {
            swap(left, right);
        }
        if (theArray[center] > theArray[right]) {
            swap(center, right);
        }
        //为什么要交换  为什么交换的位置是right-1
        swap(center, right - 1);
        return theArray[right - 1];
    }

    /**
     * 手动排序
     *
     * @param left
     * @param right
     */
    public static void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            return;
        }
        if (size == 2) {
            if (theArray[left] > theArray[right]) {
                swap(left, right);
            }
            return;
        } else {
            if (theArray[left] > theArray[right - 1]) {
                swap(left, right - 1);
            }
            if (theArray[left] > theArray[right]) {
                swap(left, right);
            }
            if (theArray[right - 1] > theArray[right]) {
                swap(right - 1, right);
            }
        }
    }


    public static void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
