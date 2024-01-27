package com.example.base.数据结构和算法.leetcode.二分查找.搜索旋转排序数组;

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i;
                break;
            }
        }
        int ans = find(nums, 0, idx, target);
        if (ans != -1) {
            return ans;
        }
        if (idx + 1 < n) {
            ans = find(nums, idx + 1, n - 1, target);
        }
        return ans;
    }

    int find(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
