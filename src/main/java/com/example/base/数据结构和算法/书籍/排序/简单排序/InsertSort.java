package com.example.base.数据结构和算法.书籍.排序.简单排序;

/**
 * @author jiwei.xue
 * @date 2020/12/22 11:14
 * 插入排序的思想: 对数组进行局部排序
 *      从第一个元素开始循环，和数组前面的元素进行比较一一进行比较，直到找到第一个比当前元素小的元素结束。
 * 插入排序的时间复杂夫为O()
 */
public class InsertSort {

    public static void main(String[] args) {

        long[] arr = new long[]{23, 4, 67, 100, 300, 97, 81};
        insertSort(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j] + " ");
        }
        System.out.println("");
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(long[] arr) {
        int out, in;
        for (out = 1; out < arr.length; out++) {
            long temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }

    public static void insertSortRe(long[] arr) {
        int out, in;
        for (out = 1; out < arr.length; out++) {
            long temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }
}
