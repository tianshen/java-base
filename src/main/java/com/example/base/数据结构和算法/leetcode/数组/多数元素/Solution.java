package com.example.base.数据结构和算法.leetcode.数组.多数元素;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 4, 5};
        int i1 = majorityElement(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }

    /**
     * 互相抵消 电子中和 一直遍历，通过count来做判断
     * @param nums
     * @return
     */
    public static int majorityElement01(int[] nums) {
        int target = 0;
        // 这个count是关键点
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                target = nums[i];
                count++;
            } else if (nums[i] == target) {
                count++;
            } else {
                count--;
            }
        }
        return target;
    }

    public static int majorityElement(int[] nums) {
        // 我们想寻找的那个众数
        int target = 0;
        // 计数器（类比带电粒子例子中的带电性）
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                // 当计数器为 0 时，假设 nums[i] 就是众数
                target = nums[i];
                // 众数出现了一次
                count = 1;
            } else if (nums[i] == target) {
                // 如果遇到的是目标众数，计数器累加
                count++;
            } else {
                // 如果遇到的不是目标众数，计数器递减
                count--;
            }
        }
        // 回想带电粒子的例子
        // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
        return target;
    }
}