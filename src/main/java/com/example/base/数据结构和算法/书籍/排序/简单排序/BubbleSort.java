package com.example.base.数据结构和算法.书籍.排序.简单排序;

/**
 * 冒泡排序:
 *      从队列的最左边开始，比较0号位置和1号位置的队员。如果左边的队员高，就让两个队员交换。如果右边的队员高，就什么也不做。
 *      然后右移一个位置，比较1号位置和2号位置的队员，和刚才一样，如果左边的队员高，则两个队员交换位置。
 *      时间复杂度为O(n^2)
 */

public class BubbleSort {

    public static void main(String[] args) {

        long[] arr = new long[]{23, 4, 67, 100, 300, 97, 81};
        bubbleSort02ReRe(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j] + " ");
        }
        System.out.println("");
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort01(long[] arr) {
        int out, in;
        // arr.length - 1 是数组的个数，外层循环的次数为数组个数 - 1
        for (out = arr.length - 1; out > 1; out--) {
            // 当外层循环每循环一次，内层循环比较的个数就 - 1，则外层循环了几次，则内层循环的个数就减去几。
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    swap(arr, in, in + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 比较好理解
     * 外层循环的次数是数组长度 - 1次，内层循环的次数是外层循环每走一次，内层的比较的个数就会 - 1
     * @param arr
     */
    private static void bubbleSort02(long[] arr) {
        int i, j;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
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

    /**
     * 重复测试
     * @param arr
     */
    public static void bubbleSort01Re(long[] arr) {
        int out, in;
        // 外层循环的次数
        for (out = arr.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    swap(arr, in, in + 1);
                }
            }
        }
    }

    /**
     * 重复测试   冒泡排序第二种方法
     * @param arr
     */
    public static void bubbleSort02Re(long[] arr) {
        int i, j;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort(long[] arr) {
        int out, in;
        for (out = arr.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    swap(arr, in, in + 1);
                }
            }
        }
    }

    public static void bubbleSort02ReRe(long[] arr) {
        int i, j;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }



}





