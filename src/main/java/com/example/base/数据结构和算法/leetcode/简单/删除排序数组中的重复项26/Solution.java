package com.example.base.数据结构和算法.leetcode.简单.删除排序数组中的重复项26;

/**
 * @author jiwei.xue
 * @date 2021/1/25 9:42
 * 双指针 快慢指针 排序的数组
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3, 3, 5, 6, 6, 6};
        int number = removeDuplicates(nums);
        System.out.println(number);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }

    /**
     *  双指针 快慢指针 通过指定索引覆盖
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
