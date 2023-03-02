package com.example.base.数据结构和算法.leetcode.求array中最大值;

/**
 * 使用递归的方法
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int max = getMax(arr);
        System.out.println(max);
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L + R) / 2;
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
