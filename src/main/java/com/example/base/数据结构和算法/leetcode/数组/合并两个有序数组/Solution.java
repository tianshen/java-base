package com.example.base.数据结构和算法.leetcode.数组.合并两个有序数组;

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
        merge04(A, m, B, n);
        for (int i = 0; i <= A.length - 1; i++) {
            System.out.print(A[i] + " ");
        }

    }


    /**
     * 合两个有序数组
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge04(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }


    public static void merge01(int[] A, int m, int[] B, int n) {
        //   1 3 5 7 9
        //   2 4 6 8 10 11

    }

    /**
     * 合并两个有序数组
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        // A数组的索引
        int i = m - 1;
        // B数组的索引
        int j = n - 1;
        // 新的数组的索引
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
            A[index--] = A[i--];
        }

    }

    public void merge02(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }


}
