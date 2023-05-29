package com.example.base.数据结构和算法.leetcode.数组.滑动窗口.最长无重复子串3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xue
 * @date 2023/4/9 16:52
 */
public class Solution {

    public static void main(String[] args) {
        String s = "addfcdedgdfekl";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0; // 记录结果
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 在这里更新答案 todo 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
