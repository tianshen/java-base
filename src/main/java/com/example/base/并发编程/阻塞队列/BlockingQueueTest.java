package com.example.base.并发编程.阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xue
 * @date 2023/4/14 16:40
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        arrayBlockingQueue.put("111");

        // 最大值为Integer.MAX_VALUE  可能导致内存溢出
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(100);
        linkedBlockingQueue.put("111");
        linkedBlockingQueue.take();

        DelayQueue<OrderInfo> queue = new DelayQueue<>();
        queue.put(new OrderInfo());

    }
}
