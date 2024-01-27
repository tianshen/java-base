package com.example.base.数据结构和算法.leetcode.数组.最后一个单词的长度;

class Solution {

    public static void main(String[] args) {
        String s = " hello world  ";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }
    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}