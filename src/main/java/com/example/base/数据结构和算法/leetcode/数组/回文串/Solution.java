package com.example.base.数据结构和算法.leetcode.数组.回文串;


/**
 * @author xue
 * @date 2023/4/9 0:27
 */
public class Solution {

    public static void main(String[] args) {
        String s = "12321";
        char[] chars = s.toCharArray();
        boolean palindrome = isPalindrome02(new char[]{'a', 'b', 'a'});
        System.out.println(palindrome);



        String ss = "Hello   World dlrow olleH    ";
        String s1 = updateStr(ss);
        boolean palindrome02 = isPalindrome02(s1.toCharArray());
        System.out.println(palindrome02);

    }

    public static String updateStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 是否是数字或字符
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }


    /**
     * 是否是回文串
     *
     * @param arr
     * @return
     */
    public static boolean isPalindrome02(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 是否是回文串
     *
     * @param arr
     * @return
     */
    public static boolean isPalindrome(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
