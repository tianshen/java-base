package com.example.base.数据结构和算法.leetcode.数组.最长公共前缀;

class Solution {

    public static void main(String[] args) {

        String[] strArr = {"flow", "flww", "floee"};
        String longestedCommonPrefix = longestCommonPrefix(strArr);
        System.out.println(longestedCommonPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        int m = strs.length;
        // 以第一行的列数为基准
        int n = strs[0].length();
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                String thisStr = strs[row];
                String prevStr = strs[row - 1];
                // 判断每个字符串的 col 索引是否都相同
                if (col >= thisStr.length() || col >= prevStr.length() ||
                        thisStr.charAt(col) != prevStr.charAt(col)) {
                    // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                    return strs[row].substring(0, col);
                }
            }
        }
        return strs[0];
    }
}