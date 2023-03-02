package com.example.base.数据结构和算法.leetcode.按权重随机选择;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Solution {

    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    // Random rand = new Random();
    // ThreadLocalRandom


    public Solution(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
        //System.out.println(tot);
        //System.out.println(psum);
    }

    public int pickIndex() {
        int targ = ThreadLocalRandom.current().nextInt(tot);
        // int targ = rand.nextInt(tot);
        //System.out.println(targ);
        int lo = 0;
        int hi = psum.size() - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] array = {15, 35, 50};
        Solution solution = new Solution(array);
        Map<Integer, Integer> indexMap = Maps.newHashMap();
        List<Integer> list0 = Lists.newArrayList();
        List<Integer> list1 = Lists.newArrayList();
        List<Integer> list2 = Lists.newArrayList();
        for (int i = 0; i < 10000000; i++) {
            int pickIndex = solution.pickIndex();
            //System.out.println(pickIndex);
            if (pickIndex == 0) {
                // boolean containsKey = indexMap.containsKey(pickIndex);
                // if (containsKey) {
                //     Integer count = indexMap.get(pickIndex);
                //     count += count;
                //     indexMap.put(pickIndex, count);
                // } else {
                //     indexMap.put(pickIndex, 1);
                // }
                list0.add(pickIndex);
            }
            if (pickIndex == 1) {
                // boolean containsKey = indexMap.containsKey(pickIndex);
                // if (containsKey) {
                //     Integer count = indexMap.get(pickIndex);
                //     count += count;
                //     indexMap.put(pickIndex, count);
                // } else {
                //     indexMap.put(pickIndex, 1);
                // }
                list1.add(pickIndex);
            }
            if (pickIndex == 2) {
                // boolean containsKey = indexMap.containsKey(pickIndex);
                // if (containsKey) {
                //     Integer count = indexMap.get(pickIndex);
                //     count += count;
                //     indexMap.put(pickIndex, count);
                // } else {
                //     indexMap.put(pickIndex, 1);
                // }
                list2.add(pickIndex);
            }
            // if (pickIndex == 3) {
            //     // boolean containsKey = indexMap.containsKey(pickIndex);
            //     // if (containsKey) {
            //     //     Integer count = indexMap.get(pickIndex);
            //     //     count += count;
            //     //     indexMap.put(pickIndex, count);
            //     // } else {
            //     //     indexMap.put(pickIndex, 1);
            //     // }
            //     list3.add(pickIndex);
            // }
        }
        System.out.println(list0.size());
        System.out.println(list1.size());
        System.out.println(list2.size());
        // System.out.println(list3.size());
    }
}
