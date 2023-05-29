package com.example.base.数据结构和算法.leetcode.随机打乱;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1,2,3});
//        Collections.shuffle(list);
        shuffle(list);
        System.out.println(list);

    }

    private static void shuffle(List<Integer> list) {
        Random random = new Random();
        for (int i = list.size(); i > 1; i--) {
            int j = random.nextInt(i);
            int index = i - 1;
            list.set(index,list.set(j,list.get(index)));
        }
    }
}