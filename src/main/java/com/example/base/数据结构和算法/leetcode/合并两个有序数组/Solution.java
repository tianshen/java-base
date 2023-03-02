package com.example.base.数据结构和算法.leetcode.合并两个有序数组;

public class Solution {

    public static void main(String[] args) {

        int[] A = new int[11];
        A[0] = 10;
        A[1] = 13;
        A[2] = 15;
        A[3] = 17;
        A[4] = 19;
        A[5] = 21;
        int m = 6;
        int[] B = {1, 2, 4, 6, 8};
        int n = 5;
        merge(A, m, B, n);
        for (int i = 0; i <= A.length - 1; i++) {
            System.out.print(A[i] + " ");
        }

    }


    public static void merge01(int[] A, int m, int[] B, int n) {
        //   1 3 5 7 9
        //   2 4 6 8 10 11

    }


    public static void merge(int[] A, int m, int[] B, int n) {
        int j = n - 1;
        int i = m - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            //A[index--] = A[i] > B[j] ? A[i--] : B[j--];
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }

        while (j >= 0) {
            A[index--] = B[j--];
        }
        while (i>= 0) {
            A[index--] = B[i--];
        }

    }
}
