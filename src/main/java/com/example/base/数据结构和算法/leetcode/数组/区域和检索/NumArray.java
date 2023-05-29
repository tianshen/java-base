package com.example.base.数据结构和算法.leetcode.数组.区域和检索;

/**
 * @author xue
 * @date 2023/4/9 12:41
 */
public class NumArray {

    int[] nums;

    public NumArray(int[] arr) {
        this.nums = arr;
    }

    /**
     * 遍历求和
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        int res = 0;
        for (int i = left; left <= right; left++) {
            res += nums[i];
        }
        return res;
    }
}
