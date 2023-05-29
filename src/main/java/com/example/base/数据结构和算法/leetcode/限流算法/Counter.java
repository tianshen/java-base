package com.example.base.数据结构和算法.leetcode.限流算法;

/**
 * 最简单的计数器限流算法
 */
public class Counter {
    // 开始时间
    public long timeStamp = System.currentTimeMillis();
    // 初始化计数器
    public int reqCount = 0;
    // 时间窗口内最大请求数
    public final int limit = 100;
    // 时间窗口ms
    public final long interval = 1000 * 60;

    public boolean limit() {
        long now = System.currentTimeMillis();
        if (now < timeStamp + interval) {
            // 在时间窗口内
            reqCount++;
            // 判断当前时间窗口内是否超过最大请求控制数
            return reqCount <= limit;
        } else {
            timeStamp = now;
            // 超时后重置
            reqCount = 1;
            return true;
        }
    }
}