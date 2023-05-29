package com.example.base.数据结构和算法.leetcode.HASH.和为k的子数组;

import java.util.HashMap;

/**
 * @author xue
 * @date 2023/4/25 20:50
 */
public class Solution {

    public static void main(String[] args) {
        int[] mums = {1, 2, 3};
        int i = subarraySum2(mums, 3);
        System.out.println(i);
    }

    //哈希优化
    public static int subarraySum2(int[] nums, int k) {
        //统计
        int count = 0;
        //前缀和
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>(); //哈希表

        for (int num : nums) { //从左往右
            sum += num; //累加
            if (sum == k) { //从下标 0 累加到 i 刚好等于 k
                count++;
            }
            if (hashMap.containsKey(sum - k)) {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
