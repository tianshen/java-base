package com.example.base.数据结构和算法.leetcode.数组.数组26_删除有序数组中的重复项;

/**
 * @author xue
 * @date 2023/4/8 21:31
 */
public class Solution {

    public static void main(String[] args) {
        int i = removeDuplicates(new int[]{1, 2, 2, 3, 4, 5, 5, 5, 6});

    }

    /**
     * 使用快慢指针  本质上是把后面的不重复的元素向前提
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates02(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                // 不等于的时候才去加
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


    /**
     * 使用快慢指针 删除重复项    本质是把后面的不重复的元素向前提
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
