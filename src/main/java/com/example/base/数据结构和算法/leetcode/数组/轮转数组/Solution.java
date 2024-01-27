package com.example.base.数据结构和算法.leetcode.数组.轮转数组;

class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    public static void rotate(int[] nums, int k) {
        // 这个怎么想出来   取余
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 数组反转 使用双指针
     *
     * @param nums
     * @param start
     * @param end
     */
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}