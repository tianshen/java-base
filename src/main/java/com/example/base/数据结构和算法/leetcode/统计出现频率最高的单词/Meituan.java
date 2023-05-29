package com.example.base.数据结构和算法.leetcode.统计出现频率最高的单词;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Meituan {
    public static void main(String[] args) throws Exception {
        // 题目提供的英文句子
        String s = "In school and life, the most important driving force of work is the pleasure in work, the pleasure of working as a result, and the recognition of the social value of this result.";
        // 通过切割方法获取String数组从而方便统计每个单词出现数量
        String[] wordList = s.split(" ");
        // 通过map键值存储单词以及出现数量
        HashMap<String, Integer> map = new HashMap<>(16);
        // 遍历单词数组
        for (int i = 0; i < wordList.length; i++) {
            // 当前遍历的单词是否在map里
            if (map.get(wordList[i]) == null) {
                // 没有就放入，并设置出现一次
                map.put(wordList[i], 1);
            } else {
                // 如果已存在则获取当前map中这个单词的出现次数
                int num = map.get(wordList[i]);
                // 加一放回
                map.put(wordList[i], ++num);
            }
        }

        // 存放map的key
        String[] mapKey = new String[wordList.length];
        // 存放map的value
        int[] mapValue = new int[wordList.length];
        int count = 0;
        Iterator it = map.entrySet().iterator();
        // 迭代循环储存到定义的容器中
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            mapKey[count] = (String) entry.getKey();
            mapValue[count] = (int) entry.getValue();
            count++;
        }

        Sort(mapKey, mapValue);
    }

    //创建排序方法
    public static void Sort(String[] mapKey, int[] mapValue) {
        String[] str = new String[3];
        for (int j = 0; j < mapValue.length - 1; j++) {
            for (int k = 0; k < mapValue.length - j - 1; k++) {
                if (mapValue[k] < mapValue[k + 1]) {
                    int temp1 = mapValue[k];
                    mapValue[k] = mapValue[k + 1];
                    mapValue[k + 1] = temp1;

                    String temp2 = mapKey[k];
                    mapKey[k] = mapKey[k + 1];
                    mapKey[k + 1] = temp2;
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            str[j] = mapKey[j] + "=" + mapValue[j];
        }
        System.out.println(str[0] + "\n" + str[1] + "\n" + str[2]);
    }
}
