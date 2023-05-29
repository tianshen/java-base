package com.example.base.数据结构和算法.leetcode.数组.数组344_反转字符数组;

/**
 * @author xue
 * @date 2023/4/9 0:16
 */
public class Solution {

    public static void main(String[] args) {
        char[] chars = reverseCharArr(new char[]{'h', 'e', 'l', 'l', 'o'});
        for (char c : chars) {
            System.out.println(c);
        }
    }

    /**
     * 反转数组
     *
     * @param arr
     * @return
     */
    public static char[] reverseCharArr(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
}
