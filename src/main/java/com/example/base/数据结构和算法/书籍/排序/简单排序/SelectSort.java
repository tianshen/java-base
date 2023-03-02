package com.example.base.数据结构和算法.书籍.排序.简单排序;

/**
 * @author jiwei.xue
 * @date 2020/12/22 10:54
 * 选择排序的思想: 循环找出最小的值，把它放在数组的最前面
 * 和冒泡排序比较: 比较的次数是一样的，但是交换的次数为arr.length - 1次
 */
public class SelectSort {

    public static void main(String[] args) {

        long[] arr = new long[]{23, 4, 67, 100, 300, 97, 81};
        selectSort2(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j] + " ");
        }
        System.out.println("");
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(long[] arr) {
        // 需要min变量来保存最小值
        int out, in, min;
        for (out = 0; out < arr.length - 1; out++) {
            min = out;
            for (in = out + 1; in < arr.length; in++) {
                if (arr[in] < arr[min]) {
                    min = in;
                }
            }
            swap(arr, out, min);
        }
    }

    /**
     * 选择排序两种方式是一样的
     *
     * @param array
     */
    public static void selectSort2(long[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }

    }

    /**
     * 选择排序重新测试
     * @param arr
     */
    public static void selectSort01Re(long[] arr) {
        int min, out, in;
        for (out = 0; out < arr.length - 1; out++) {
            min = out;
            for (in = out + 1; in < arr.length; in++) {
                if (arr[in] < arr[min]) {
                    min = in;
                }
            }
            swap(arr, out, min);
        }
    }


    /**
     * 交换位置
     *
     * @param arr
     * @param one
     * @param two
     */
    private static void swap(long[] arr, int one, int two) {
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
