package com.example.base.数据结构和算法.leetcode.HASH.单词规律;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        boolean b = wordPattern02("abba", "dog cat cat dog");
        System.out.println(b);
    }

    /**
     * 这个方法可以
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern03(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (chars.length != strings.length)
            return false;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i]) && !map.containsValue(strings[i])) {
                map.put(chars[i], strings[i]);
            } else if (map.get(chars[i]) == null || !map.get(chars[i]).equals(strings[i])) {
                return false;
            }
        }
        return true;
    }


    public static boolean wordPattern02(String pattern, String s) {
        String[] lis = s.split(" ");
        if (pattern.length() != lis.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < lis.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(lis[i])) {
                    return false;
                }
            } else {
                if (set.contains(lis[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), lis[i]);
                set.add(lis[i]);
            }
        }
        return true;
    }



    public static boolean wordPattern01(String pattern, String s) {
        // 使用map来实现
        Map<Character, String> map = new HashMap<>();
        String[] array = s.split(" ");

        if (pattern.length() != s.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i ++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                String value = map.get(key);
                if (!value.equals(array[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(array[i])) {
                    return false;
                }
                map.put(key, array[i]);
            }

        }
        return false;
    }


}