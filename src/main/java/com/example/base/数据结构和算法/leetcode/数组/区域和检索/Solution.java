package com.example.base.数据结构和算法.leetcode.数组.区域和检索;

/**
 * @author xue
 * @date 2023/4/9 12:36
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static int sumRange(int[] nums, int left, int right) {
        int res = 0;
        for (int i = left; left <= right; left++) {
            res += nums[i];
        }
        return res;
    }
}
