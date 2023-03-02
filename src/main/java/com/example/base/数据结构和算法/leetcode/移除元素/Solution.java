package com.example.base.数据结构和算法.leetcode.移除元素;

/**
 * 使用快慢指针
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {4, 5, 5, 6, 7, 8};
        System.out.println(removeElement(nums, 5));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
