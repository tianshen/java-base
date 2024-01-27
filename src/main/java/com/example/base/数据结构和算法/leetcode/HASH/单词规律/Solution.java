package com.example.base.数据结构和算法.leetcode.HASH.单词规律;

import java.util.HashMap;

class Solution {

    public static void main(String[] args) {

    }
    // 哈希表
    public boolean wordPattern(String pattern , String str) {
        // patter每个单词作为key str每个单词作为value
        HashMap<Character , String> map = new HashMap<Character , String>();
        String[] array = str.split(" ");
        // 字母和单词个数不一致
        if (pattern.length() != array.length) {
            return false;
        }
        for (int i = 0 ; i < pattern.length() ; i++) {
            char key = pattern.charAt(i);
            //当前key是否存在
            if (map.containsKey(key)) {
                if (!map.get(key).equals(array[i])) {
                    return false;
                }
            } else {
                // 判断value中是否存在
                if(map.containsValue(array[i])) {
                    return false;
                }
                map.put(key , array[i]);
            }
        }
        return true;
    }
}