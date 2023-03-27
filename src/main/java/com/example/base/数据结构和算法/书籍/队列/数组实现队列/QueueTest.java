package com.example.base.数据结构和算法.书籍.队列.数组实现队列;

public class QueueTest {

    public static void main(String[] args) {

        Queue queue = new Queue(5);
        queue.insert(5);
        queue.insert(4);
        queue.insert(3);
        queue.insert(2);
        queue.insert(1);
        queue.insert(7);
        System.out.println(queue);
    }
}
