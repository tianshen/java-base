package com.example.base.数据结构和算法.leetcode.最长公共前缀14;

/**
 * @author jiwei.xue
 * @date 2021/1/7 14:52
 */
public class Solution {

    public static void main(String[] args) {

        String[] strs = {"abc", "abcde", "abcft", "abcef"};
        String longestCommonPrefix = longestCommonPrefix(strs);
        System.out.println(longestCommonPrefix);
    }

    /**
     * 纵向扫描
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;

        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
