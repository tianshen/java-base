package com.example.base;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HongbaoTes {
    private static final Logger logger = LoggerFactory.getLogger(HongbaoTes.class);

    public static void main(String[] args) {
        // List<Integer> integers = makeRedPacket(100, 5);
        // for (Integer integer : integers) {
        //     logger.info("{}", integer);
        // }
        
        // 测试新方法
        List<Integer> randomParts = splitTotalRandomly(1000, 8);
        logger.info("随机分配结果: {}", randomParts);
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

    /**
     * 将总数随机分配为指定份数，确保每份都大于0
     * @param total 要分配的总数
     * @param parts 需要分成的份数
     * @return 分配结果列表
     */
    public static List<Integer> splitTotalRandomly(int total, int parts) {
        if (total < parts) {
            throw new IllegalArgumentException("总数必须大于等于份数，否则无法保证每份都大于0");
        }

        List<Integer> result = new ArrayList<>(parts);
        
        // 先给每份分配1，确保每份都不为0
        int remaining = total - parts;
        
        // 生成parts-1个随机点
        List<Integer> points = new ArrayList<>(parts - 1);
        Random random = new Random();
        for (int i = 0; i < parts - 1; i++) {
            points.add(random.nextInt(remaining));
        }
        
        // 排序这些点
        Collections.sort(points);
        
        // 计算每份的大小
        int prev = 0;
        for (int i = 0; i < points.size(); i++) {
            result.add(points.get(i) - prev + 1); // +1是因为之前预留的1
            prev = points.get(i);
        }
        // 添加最后一份
        result.add(remaining - prev + 1);
        
        return result;
    }

}
