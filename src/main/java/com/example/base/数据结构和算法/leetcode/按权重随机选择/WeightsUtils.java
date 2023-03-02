package com.example.base.数据结构和算法.leetcode.按权重随机选择;

import com.google.common.collect.Lists;

import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

public class WeightsUtils {

    List<Double> intervals = Lists.newArrayList();
    double weightsInterval = 0.0;

    public WeightsUtils(List<Double> weightsList) {
        for (double weights : weightsList) {
            System.out.println(weights);
            weightsInterval += weights;
            intervals.add(weightsInterval);
        }
        System.out.println(intervals);
    }

    public int pickIndex() {
        double nextDouble = ThreadLocalRandom.current().nextDouble(weightsInterval);
        int low = 0;
        int hight = intervals.size() - 1;
        while (low != hight) {
            int middle = (low + hight) / 2;
            if (nextDouble >= intervals.get(middle)) {
                low = middle + 1;
            } else {
                hight = middle;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        List<Integer> list0 = Lists.newArrayList();
        List<Integer> list1 = Lists.newArrayList();
        List<Integer> list2 = Lists.newArrayList();
        List<Integer> list3 = Lists.newArrayList();
        List<Integer> list4 = Lists.newArrayList();
        List<Integer> list5 = Lists.newArrayList();
        List<Integer> list6 = Lists.newArrayList();
        List<Integer> list7 = Lists.newArrayList();
        List<Double> list = Lists.newArrayList();
        list.add(0.0);
        list.add(0.1);
        list.add(0.1);
        list.add(0.1);
        list.add(0.1);
        list.add(0.1);
        list.add(0.1);
        list.add(0.4);
        WeightsUtils weightsUtils = new WeightsUtils(list);
        for (int i = 0; i < 10000000; i++) {
            // double[] array = {0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.4};

            int pickIndex = weightsUtils.pickIndex();
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
            if (pickIndex == 3) {
                list3.add(pickIndex);
            }
            if (pickIndex == 4) {
                list4.add(pickIndex);
            }
            if (pickIndex == 5) {
                list5.add(pickIndex);
            }
            if (pickIndex == 6) {
                list6.add(pickIndex);
            }
            if (pickIndex == 7) {
                list7.add(pickIndex);
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
        System.out.println(list3.size());
        System.out.println(list4.size());
        System.out.println(list5.size());
        System.out.println(list6.size());
        System.out.println(list7.size());
        // System.out.println(list3.size());
    }
}
