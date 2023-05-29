package com.example.base.数据结构和算法.leetcode.抽奖;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WeightsUtils {

    private final List<Double> intervals = Lists.newArrayList();
    public double weightsInterval = 0.0;

    public WeightsUtils(List<Double> weightsList) {
        for (double weights : weightsList) {
            weightsInterval += weights;
            intervals.add(weightsInterval);
        }
    }

    public int pickIndex() {
        double nextDouble = ThreadLocalRandom.current().nextDouble(weightsInterval);
        int low = 0;
        int high = intervals.size() - 1;
        while (low != high) {
            int middle = (low + high) / 2;
            if (nextDouble >= intervals.get(middle)) {
                low = middle + 1;
            } else {
                high = middle;
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
        for (int i = 0; i < 10000000; i++) {
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
            int pickIndex = weightsUtils.pickIndex();
            if (pickIndex == 0) {
                list0.add(pickIndex);
            }
            if (pickIndex == 1) {
                list1.add(pickIndex);
            }
            if (pickIndex == 2) {
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
        }
        System.out.println(list0.size());
        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());
        System.out.println(list4.size());
        System.out.println(list5.size());
        System.out.println(list6.size());
        System.out.println(list7.size());

    }
}
