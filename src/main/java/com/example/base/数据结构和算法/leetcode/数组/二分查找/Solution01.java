package com.example.base.数据结构和算法.leetcode.数组.二分查找;

public class Solution01 {

    public static void main(String[] args) {
        int left = 2;
        int right = 4;
        int mid = left + (right - left) / 2;
        System.out.println(mid);
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
