package com.example.base.数据结构和算法.leetcode.数组.回文串;

/**
 * @author xue
 * @date 2023/4/9 0:27
 */
public class Solution {

    public static void main(String[] args) {
        String s = "12321";
        char[] chars = s.toCharArray();
        boolean palindrome = isPalindrome(new char[]{'a', 'b', 'c'});
        System.out.println(palindrome);
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
