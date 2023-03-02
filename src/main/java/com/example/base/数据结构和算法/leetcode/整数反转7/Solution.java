package com.example.base.数据结构和算法.leetcode.整数反转7;

/**
 * @author jiwei.xue
 * @date 2021/1/6 10:31
 */
public class Solution {

    public static void main(String[] args) {

        int reverse = reverse(2147483647);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {return 0;}
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {return 0;}
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
