package com.example.base.数据结构和算法.leetcode.罗马数字转整数13;

/**
 * @author jiwei.xue
 * @date 2021/1/7 14:28
 */
public class Solution {

    public static void main(String[] args) {



    }

    public static int romanToInt(String s) {
        int sum = 0;
        int perNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (perNum < num) {
                sum -= perNum;
            } else {
                sum += perNum;
            }
            perNum = num;
        }
        sum += perNum;
        return sum;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
