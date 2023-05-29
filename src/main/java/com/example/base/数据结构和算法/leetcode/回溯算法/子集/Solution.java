package com.example.base.数据结构和算法.leetcode.回溯算法.子集;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        backtrack(nums, 0);
        System.out.println(res);

    }

    static List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    static LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    public static void backtrack(int[] nums, int start) {

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));
        
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择 遍历这棵树
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}