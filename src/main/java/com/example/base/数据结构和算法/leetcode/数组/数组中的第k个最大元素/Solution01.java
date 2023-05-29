package com.example.base.数据结构和算法.leetcode.数组.数组中的第k个最大元素;

import java.util.Arrays;

public class Solution01 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }
}