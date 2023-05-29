package com.example.base.数据结构和算法.leetcode.数组.前k个高频元素;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 2 ,4, 5, 4, 2, 3, 3, 3};
        int[] ints = topKFrequent(nums, 2);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        // 遍历数组放到一个hashMap中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        //
        for (Map.Entry<Integer, Integer> entry : entries) {
            // 往堆里放元素
            queue.offer(entry);
            if (queue.size() > k) {
                // 如果大于的话 往出拿
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}