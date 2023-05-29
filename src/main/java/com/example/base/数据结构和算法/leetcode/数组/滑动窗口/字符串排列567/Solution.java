package com.example.base.数据结构和算法.leetcode.数组.滑动窗口.字符串排列567;

import com.google.common.collect.Maps;
import com.sun.org.apache.bcel.internal.generic.CHECKCAST;

import java.util.Map;

/**
 * @author xue
 * @date 2023/4/9 15:57
 */
public class Solution {

    public static void main(String[] args) {

        String t = "ABC";
        String s = "ABCDABDC";
        boolean b = checkInclusion(t, s);
        System.out.println(b);
    }

    public static boolean checkInclusion(String t, String s) {

        Map<Character, Integer> need = Maps.newHashMap();
        Map<Character, Integer> window = Maps.newHashMap();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 关键点  判断这个字符串的长度 必须和子串的长度相同才可以
            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    return true;
                }
                // 缩减窗口
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
