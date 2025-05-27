package com.example.base.数据结构和算法.leetcode.栈.有效的括号;

import java.util.*;

/**
 * 有效的括号 20题
 */
class Solution {

    public static void main(String[] args) {
        // String s = "()[]{}";
        String s = "({[})";
        boolean valid = new Solution().isValid(s);
        System.out.println(valid);
    }


    public boolean isValid(String s) {
        int n = s.length();
        // 取余 判断是奇数还是偶数
        if (n % 2 == 1) {
            return false;
        }

        // 通过一个map存储所有的字符 key代表右边的字符 value为左边的字符
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            // 遍历获取每一个字符
            char ch = s.charAt(i);
            // 通过key判断是否包含这个字符 如果包含，从栈中弹出一个元素进行比较
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                // 弹出栈
                stack.pop();
                // 如果不包含 则压入栈中
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}