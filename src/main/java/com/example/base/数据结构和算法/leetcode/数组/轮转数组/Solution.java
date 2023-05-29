package com.example.base.数据结构和算法.leetcode.数组.轮转数组;

class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};

    }


    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
}