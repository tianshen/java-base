package com.example.base.数据结构和算法.leetcode.查找任意一个重复的数字;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * 查找数组中重复的数
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
