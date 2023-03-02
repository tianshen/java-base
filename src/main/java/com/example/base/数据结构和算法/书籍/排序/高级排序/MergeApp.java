package com.example.base.数据结构和算法.书籍.排序.高级排序;

/**
 * 归并两个有序数组
 * 对两个有序的数组进行排序
 */
public class MergeApp {

    public static void main(String[] args) {
        int[] arrayA = {23, 47, 81, 95};
        int sizeA = arrayA.length;
        int[] arrayB = {7, 14, 39, 55, 62, 74};
        int sizeB = arrayB.length;
        int[] arrayC = new int[10];
        merge(arrayA, sizeA, arrayB, sizeB, arrayC);
        display(arrayC, arrayC.length);
    }

    /**
     * 对两个有序数组排序
     *
     * @param arrayA
     * @param sizeA
     * @param arrayB
     * @param sizeB
     * @param arrayC
     */
    public static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
        int aDex = 0;
        int bDex = 0;
        int cDex = 0;
        while (aDex < sizeA && bDex < sizeB) {
            if (arrayA[aDex] < arrayB[bDex]) {
                arrayC[cDex++] = arrayA[aDex++];
            } else {
                arrayC[cDex++] = arrayB[bDex++];
            }
        }

        while (aDex < sizeA) {
            arrayC[cDex++] = arrayA[aDex++];
        }

        while (bDex < sizeB) {
            arrayC[cDex++] = arrayB[bDex++];
        }
    }

    /**
     * @param theArray
     * @param size
     */
    public static void display(int[] theArray, int size) {
        for (int j = 0; j < size; j++) {
            System.out.println(theArray[j] + " ");
        }
        System.out.println("");
    }
}
