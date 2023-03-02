package com.example.base.数据结构和算法.leetcode.只出现一次的数字136;

/**
 * @author jiwei.xue
 * @date 2021/1/6 11:27
 *
 * 1、任何数和0做异或运算，结果仍然是原来的数，即 a^0=a
 * 2、任何数和自身做异或运算，结果是0，即 a^a=0
 * 3、异或运算满足交换律和结合律， 即 a^b^a=b^a^a=b^(a^a)=b^0=b
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 4, 4, 6, 7, 6, 7};
        int single = singleNumber(nums);
        System.out.println(single);
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
