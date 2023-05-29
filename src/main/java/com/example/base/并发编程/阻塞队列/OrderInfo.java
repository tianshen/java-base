package com.example.base.并发编程.阻塞队列;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author xue
 * @date 2023/4/14 17:18
 */
public class OrderInfo implements Delayed {
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
