package com.example.base.数据结构和算法.leetcode.数组.数组167_两数之和II;

/**
 * @author xue
 * @date 2023/4/8 21:31
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 13);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    /**
     * 两数之和 数组是有序的
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum02(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }



    /**
     * 两数之和 进阶版 数组是有序的
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};

    }
}
