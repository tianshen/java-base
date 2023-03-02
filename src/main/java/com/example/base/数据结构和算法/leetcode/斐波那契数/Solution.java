package com.example.base.数据结构和算法.leetcode.斐波那契数;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiwei.xue
 * @date 2021/1/4 17:10
 */
public class Solution {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int fit = fit(10);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(fit);

    }


    /**
     * F(n) = F(n-1) + F(n-2)
     *
     * @param n
     * @return
     */
    public static int fit(int n) {
        if (n < 2) {
            return n;
        }
        return fit(n - 1) + fit(n - 2);
    }


    public static int fit01(int n) {
        return fit01(n, new HashMap<Integer, Integer>());
    }

    public static int fit01(int n, Map<Integer, Integer> map) {
        if (n < 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int first = fit01(n - 1, map);
        int second = fit01(n - 2, map);
        int res = first + second;
        map.put(n, res);
        return res;
    }

    /**
     * 使用数组滑动
     *
     * @param n
     * @return
     */
    public static int fit02(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
