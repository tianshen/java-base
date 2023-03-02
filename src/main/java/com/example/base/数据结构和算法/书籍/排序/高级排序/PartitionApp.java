package com.example.base.数据结构和算法.书籍.排序.高级排序;

/**
 * @author jiwei.xue
 * @date 2020/12/24 10:00
 */
public class PartitionApp {

    public static void main(String[] args) {
        long[] theArray = {33, 66, 22, 77, 55, 11, 99, 44, 88};
        int partitionIt = partitionIt(theArray, 0, theArray.length - 1, 55);
        System.out.println(partitionIt);
        System.out.println("------------------------------");
        for (int j = 0; j < theArray.length; j++) {
            System.out.println(theArray[j] + " ");
        }
        System.out.println("");
    }

    public static int partitionIt(long[] theArray, int left, int right, int pivot) {

        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            // 左边的数如果小于基准值的话，就什么也不做
            while (leftPtr < right && theArray[++leftPtr] < pivot) {

            }
            // 右边的数如果大于基准值得话，就什么都不做
            while (rightPtr > left && theArray[--rightPtr] > pivot) {

            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(theArray, leftPtr, rightPtr);
            }
        }
        return leftPtr;
    }

    public static void swap(long[] theArray, int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
