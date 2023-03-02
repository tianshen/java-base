package com.example.base.数据结构和算法.书籍.排序.高级排序;

/**
 * 希尔排序是基于插入排序的 增量进行排序的
 */
public class ShellSortApp {

    public static void main(String[] args) {
        long[] theArray = {33, 66, 22, 77, 55, 11, 99, 44, 88};
        shellSort(theArray);
        for (int j = 0; j < theArray.length; j++) {
            System.out.println(theArray[j] + " ");
        }
        System.out.println("");
    }

    public static void shellSort(long[] arr) {
        int inner, outer;
        long temp;

        int h = 1;
        while (h < (arr.length / 3)) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < arr.length; outer++) {
                temp = arr[outer];
                inner = outer;

                while (inner > h - 1 && arr[inner - h] >= temp) {
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }
                arr[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

}
