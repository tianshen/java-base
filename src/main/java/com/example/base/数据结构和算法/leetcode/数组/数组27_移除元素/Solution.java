package com.example.base.数据结构和算法.leetcode.数组.数组27_移除元素;

/**
 * @author xue
 * @date 2023/4/8 22:07
 */
public class Solution {

    public static void main(String[] args) {

        int count = removeElement(new int[]{1, 2, 3, 4, 4, 4}, 4);
        System.out.println(count);
    }


    public static int removeElement01(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                // 先赋值  后++
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 移除数组中指定的元素  使用快慢指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
