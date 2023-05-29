package com.example.base.数据结构和算法.leetcode.HASH.最长连续序列;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        // 定义一个当前最长的longestStreak  这个数字和循环过程中的currentStreak进行比较，选取大的，最后得到的就是这个最大的。
        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 判断连续的数字 当不连续的时候则这个值就不在增加
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}