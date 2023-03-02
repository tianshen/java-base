package com.example.base.数据结构和算法.书籍.排序.高级排序;

public class MergeSortApp02 {

    //public static
    public static void main(String[] args) {
        long[] arr = new long[]{34, 23, 11, 56, 78, 1, 4, 9};
        process(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void process(long[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = (L + R) / 2;
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);

    }

    public static void merge(long[] arr, int L, int M, int R) {
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
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
    }
}
