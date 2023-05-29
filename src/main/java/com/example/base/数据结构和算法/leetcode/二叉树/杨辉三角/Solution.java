package com.example.base.数据结构和算法.leetcode.二叉树.杨辉三角;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author xue
 * @date 2023/4/10 15:38
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> rowList = getRowList(10);
        System.out.println(rowList);
    }

    public static List<Integer> getRowList(int rowIndex) {
        List<Integer> rowList = Lists.newArrayList();
        // 每一行开头加1
        rowList.add(1);
        // base case
        if (rowIndex == 0) {
            return rowList;
        }
        // 递归获取上一行
        List<Integer> preRowList = getRowList(rowIndex - 1);
        // 这一行的每个元素等于上一行两个相邻元素之和
        for (int i = 0; i < preRowList.size() - 1; i++) {
            rowList.add(preRowList.get(i) + preRowList.get(i + 1));
        }
        // 每一行结尾加1
        rowList.add(1);
        return rowList;
    }
}
