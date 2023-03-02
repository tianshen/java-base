package com.example.base.数据结构和算法.leetcode.两数之和1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiwei.xue
 * @date 2021/1/5 15:13
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 8, 10};
        int[] ints = new Solution().twoSum03(nums, 12);
        for (int i : ints) {
            System.out.println(i);
        }

    }

    /**
     * 遍历 暴力求解
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum02(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[0];
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum03(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
