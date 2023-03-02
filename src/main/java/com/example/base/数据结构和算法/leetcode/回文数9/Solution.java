package com.example.base.数据结构和算法.leetcode.回文数9;

/**
 * @author jiwei.xue
 * @date 2021/1/7 12:17
 */
public class Solution {

    public static void main(String[] args) {

        int x = 5678765;
        boolean isPalindrome = isPalindrome(x);
        System.out.println(isPalindrome);

    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        // 如何知道反转数字的位数已经打扫原始数字的一半
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + (x % 10);
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
