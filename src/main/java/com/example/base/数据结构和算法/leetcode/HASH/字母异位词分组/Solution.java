package com.example.base.数据结构和算法.leetcode.HASH.字母异位词分组;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            // 转成字符数组
            char[] array = str.toCharArray();
            // 对字符数组排序
            Arrays.sort(array);
            // 生成一个排序后的字符串 这个字符串主要是用作key
            String key = new String(array);
            // 获取这个key的value 默认返回空list
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            // 将最开始的字符串加入list
            list.add(str);
            // 放入map
            map.put(key, list);
        }
        // 取出values
        return new ArrayList<List<String>>(map.values());
    }
}
