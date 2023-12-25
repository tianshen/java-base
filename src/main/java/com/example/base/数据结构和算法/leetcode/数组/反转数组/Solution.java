package com.example.base.数据结构和算法.leetcode.数组.反转数组;

public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};
        reverse(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
