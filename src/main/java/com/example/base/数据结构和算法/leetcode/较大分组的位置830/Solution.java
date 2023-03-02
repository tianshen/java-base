package com.example.base.数据结构和算法.leetcode.较大分组的位置830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiwei.xue
 * @date 2021/1/5 14:59
 */
public class Solution {

    public static void main(String[] args) {

        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>> lists = new Solution().largeGroupPositions(s);
        System.out.println(lists);

    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<>();

        int n = s.length();
        int num = 1;

        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
