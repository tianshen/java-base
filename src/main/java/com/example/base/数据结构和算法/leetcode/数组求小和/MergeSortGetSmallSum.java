package com.example.base.数据结构和算法.leetcode.数组求小和;

/**
 * 求出数组的小和 归并排序
 */
public class MergeSortGetSmallSum {

    public static void main(String[] args) {
        long[] arr = new long[]{34, 23, 11, 56, 78, 1, 4, 9};
        int res = process(arr, 0, arr.length - 1);
        System.out.println(res);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int process(long[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = (L + R) / 2;
        return process(arr, L, M) + process(arr, M + 1, R) + merge(arr, L, M, R);

    }

    public static int merge(long[] arr, int L, int M, int R) {
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            // 相当与是右边的数比左边的大的时候，则右边后面的数都不比这个数大，则求出后面的的组中从当前数开始到最后还有几个数，然后乘以左边的数就是两个组比较的和
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }
}
