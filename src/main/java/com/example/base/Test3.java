package com.example.base;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class Test3 {

    public static int[] sum(int[] nums, int target) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{target - nums[i], i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
