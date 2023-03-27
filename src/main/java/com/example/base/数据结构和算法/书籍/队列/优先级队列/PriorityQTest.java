package com.example.base.数据结构和算法.书籍.队列.优先级队列;

import java.util.Arrays;

public class PriorityQTest {


    public static void main(String[] args) {

        PriorityQ priorityQ = new PriorityQ(7);
        priorityQ.insert(5);
        priorityQ.insert(6);
        priorityQ.insert(7);
        priorityQ.insert(8);
        System.out.println(Arrays.toString(priorityQ.getQueArray()));
    }
}
