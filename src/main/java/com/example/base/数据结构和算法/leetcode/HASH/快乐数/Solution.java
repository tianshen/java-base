package com.example.base.数据结构和算法.leetcode.HASH.快乐数;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        boolean happy = isHappy(29);
        System.out.println(happy);
    }

    // 求一个数的平方和
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}
