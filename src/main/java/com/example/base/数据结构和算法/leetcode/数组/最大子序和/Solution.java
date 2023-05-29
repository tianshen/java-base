package com.example.base.数据结构和算法.leetcode.数组.最大子序和;

class Solution {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            // 拿前缀数组和与单个元素比较 并记录
            pre = Math.max(pre + x, x);
            // 拿上面比较得到的元素和记录的最大的元素进行比较
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}