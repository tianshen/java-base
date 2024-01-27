package com.example.base.数据结构和算法.leetcode.HASH.赎金信;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String a, String b) {
        int[] cnt = new int[26];
        for (char c : b.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : a.toCharArray()) {
            if (--cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 标准的hash的写法
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructHash(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();
        for (char c : str2) {
            int num = map.getOrDefault(c, 0) + 1;
            map.put(c, num);
        }
        for (char c : str1) {
            if (map.containsKey(c)) {
                int num = map.get(c) - 1;
                if (num < 0)
                    return false;
                map.put(c, num);
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * 手写一遍
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructHash03(String ransomNote, String magazine) {
        Map<Character, Integer> map = Maps.newHashMap();
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();

        for (char c2 : chars2) {
            map.put(c2, map.getOrDefault(c2, 0) + 1);
        }

        for (char c1 : chars1) {
            if (map.containsKey(c1)) {
                Integer num = map.get(c1);
                if (num - 1 < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
