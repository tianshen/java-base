package com.example.base.数据结构和算法.leetcode.数组.翻转字符串里的单词;

public class Solution {

    public static void main(String[] args) {

        String s = "  hello    world   maomao   ";
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        System.out.println(sb);
    }

    public static StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
                // 关键的一步 判断前一位不是空的时候，才去加""
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }

    /**
     * 反转字符串
     *
     * @param sb
     * @param left
     * @param right
     */
    public static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            // 设置左边为右边的值
            sb.setCharAt(left, sb.charAt(right));
            // 设置右边为左边的值
            sb.setCharAt(right, tmp);
            // 左边++
            left++;
            // 右边++
            right--;
        }
    }

    /**
     * 反转每个单词
     *
     * @param sb = oamoam dlrow olleh
     */
    public static void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }

}
