package com.example.base;

import java.util.*;

public class HongbaoTes {

    public static void main(String[] args) {


        List<Integer> integers = makeRedPacket(100, 5);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static List<Integer> makeRedPacket(int total, int num) {
        int min = 1;
        int max = total - 1;
        Random random = new Random();

        Set<Integer> randomSet = new TreeSet<>();
        //随机生成num + 1个元素
        randomSet.add(0);
        while (randomSet.size() < num) {
            int s = random.nextInt(max) % (max - min + 1) + min;
            randomSet.add(s);
        }
        randomSet.add(total);

        List<Integer> redPackList = new ArrayList<>(num);
        List<Integer> randomList = new ArrayList<>(num);
        randomList.addAll(randomSet);

        for (int i = 1; i <= num; i++) {
            int val = randomList.get(i) - randomList.get(i - 1);
            redPackList.add(val);
        }

        return redPackList;
    }
}
