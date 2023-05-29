package com.example.base.数据结构和算法.leetcode.随机打乱;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;

/**
 * @author xue
 * @date 2023/4/25 1:53
 */
public class ShuffleTest {


    public static void main(String[] args) {
        int[] shuffle01 = shuffle01();
        for (int i : shuffle01) {
            System.out.println(i);
        }
    }

    /**
     * 使用Hash保证index的唯一性
     * */
    public static int[] shuffle01(){
        int[] originalData = {1,2,3,4,5,6,7};
        int len = originalData.length;
        //使用日期做种子生成真随机数
        Random random = new Random(System.currentTimeMillis());
        //限制到0-len
        int index = Math.abs(random.nextInt() % len);
        //使用HashSet来保证index的唯一性 去重,然后一直
        HashSet<Integer> set = new HashSet<>();
        //新数组存储打乱后的元素
        int[] newNums = new int[len];
        int j = 0;
        for (int i=0; i < len; i ++){
            //一直寻找新的index如果index已经存在
            while(!set.add(index)){
                //index存在时add方法为false
                index = Math.abs(random.nextInt() % len);
            }
            //将index位置的元素放进新数组
            newNums[j++] = originalData[index];
        }
        return newNums;
    }
}
