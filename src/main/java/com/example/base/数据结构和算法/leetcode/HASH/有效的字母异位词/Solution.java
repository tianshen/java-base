package com.example.base.数据结构和算法.leetcode.HASH.有效的字母异位词;

class Solution {

    public boolean isAnagram(String s, String t) {
        int[] count1 = encode(s);
        int[] count2 = encode(t);
        // 确保两个字符串中所有字符出现的数量相同
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }

    public static int count01() {
        int delta = 'b' - 'a';
        System.out.println(delta);
        return delta;
    }

    // 计算字符的出现次数
    int[] encode(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            // count[i]代表这个位置的值
            count[delta]++;
        }
        return count;
    }




    // 计算字符出现的次数
    int[] charCount(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]++;
        }
        return count;
    }

    // 利用每个字符的出现次数进行编码
    String encode01(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        for (char c : count) {
            System.out.println(c);
        }
        return new String(count);
    }

    public static void main(String[] args) {

        int i = count01();

//        Solution solution = new Solution();
//        String acb = solution.encode01("acb");
//        System.out.println(acb);

    }
}