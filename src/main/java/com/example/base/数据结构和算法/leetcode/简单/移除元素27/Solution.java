package com.example.base.数据结构和算法.leetcode.简单.移除元素27;

/**
 * @author jiwei.xue
 * @date 2021/1/25 10:30
 */
public class Solution {

    public static void main(String[] args) {
        int val = 3;
        int[] nums = {2, 5, 6, 3, 7, 8, 4, 2, 3, 5};
        int count = removeElement(nums, val);
        System.out.println(count);
        for (int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i] + "  ");
        }
    }

    /**
     *   双指针 通过指定索引覆盖
     * @param nums
     * @param val
     * @return
     */
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
