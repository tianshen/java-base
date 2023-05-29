package com.example.base.数据结构和算法.leetcode.限流算法;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author https://www.wdbyte.com
 * 固定窗口算法
 */
public class RateLimiterSimpleWindow {
    // 阈值
    private static Integer QPS = 2;
    // 时间窗口（毫秒）
    private static long TIME_WINDOWS = 1000;
    // 计数器
    private static AtomicInteger REQ_COUNT = new AtomicInteger();

    // 开始时间
    private static long START_TIME = System.currentTimeMillis();


    public synchronized static boolean tryAcquire() {
        // 当前时间减去开始时间大于时间窗口
        if ((System.currentTimeMillis() - START_TIME) > TIME_WINDOWS) {
            // 计数器归零
            REQ_COUNT.set(0);
            START_TIME = System.currentTimeMillis();
        }
        return REQ_COUNT.incrementAndGet() <= QPS;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(250);
            LocalTime now = LocalTime.now();
            if (!tryAcquire()) {
                System.out.println(now + " 被限流");
            } else {
                System.out.println(now + " 做点什么");
            }
        }
    }
}