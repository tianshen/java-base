package com.example.base.数据结构和算法.leetcode.数组.滑动窗口.找所有字母的异位词;

import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xue
 * @date 2023/4/9 15:57
 */
public class Solution {

    public static void main(String[] args) {

        String t = "ABC";
        String s = "ABCDABC";
        List<Integer> anagrams = findAnagrams(t, s);
        anagrams.forEach(System.out::println);
    }

    public static List<Integer> findAnagrams(String t, String s) {

        Map<Character, Integer> need = Maps.newHashMap();
        Map<Character, Integer> window = Maps.newHashMap();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        List<Integer> res = Lists.newArrayList();

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    res.add(left);
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
        return res;
    }
}
