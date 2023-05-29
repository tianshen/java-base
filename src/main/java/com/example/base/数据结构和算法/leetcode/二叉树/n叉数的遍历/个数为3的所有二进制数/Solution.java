package com.example.base.数据结构和算法.leetcode.二叉树.n叉数的遍历.个数为3的所有二进制数;

/**
 * @author xue
 * @date 2023/4/10 12:32
 */
public class Solution {

    static StringBuilder path = new StringBuilder();

    public static void generateBinaryNumber(int n) {
        if (n == 0) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < 2; i++) {

            // 前序
            path.append(i);
            generateBinaryNumber(n - 1);

            //后序
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        generateBinaryNumber(3);
    }
}
