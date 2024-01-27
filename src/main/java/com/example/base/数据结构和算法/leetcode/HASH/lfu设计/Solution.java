package com.example.base.数据结构和算法.leetcode.HASH.lfu设计;

import java.util.*;

public class Solution {

    public int[] LFU(int[][] operators, int k) {
        // hashMap和priorityQueue保存，hashMap存调用次数和计时，priorityQueue排序
        HashMap<Integer, Node> count = new HashMap<>();//对key计数，key=operators[i][1],value=node node.count计数 node.time 计时
        HashMap<Integer, int[]> temp = new HashMap<>(); //保存key(operators[i][1])和operators[i]的映射，好方便找出value值
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> count.get(o1).count.equals(count.get(o2).count) ?
                count.get(o1).time.compareTo(count.get(o2).time) : count.get(o1).count.compareTo(count.get(o2).count));//优先队列，取count值较小的，count值一致时取time小的
        ArrayList<Integer> res = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                if (temp.size() == k) {
                    int poll = minHeap.poll(); //把调用次数最少的poll掉
                    count.remove(poll);
                    temp.remove(poll);
                }
                //插入temp和count
                temp.put(operators[i][1], operators[i]);
                if (count.containsKey(operators[i][1])) {
                    Node node = new Node(count.get(operators[i][1]).count + 1, time++);
                    count.put(operators[i][1], node);
                    minHeap.remove(operators[i][1]);
                    minHeap.offer(operators[i][1]);
                } else {
                    Node node1 = new Node(1, time++);
                    count.put(operators[i][1], node1);
                    minHeap.offer(operators[i][1]);
                }
            } else if (operators[i][0] == 2) {
                if (temp.get(operators[i][1]) == null) {
                    res.add(-1);
                } else {
                    int[] operator = temp.get(operators[i][1]);
                    res.add(operator[2]);
                    if (count.containsKey(operators[i][1])) {
                        Node node2 = new Node(count.get(operators[i][1]).count + 1, time++);
                        count.put(operators[i][1], node2);
                        minHeap.remove(operators[i][1]);
                        minHeap.offer(operators[i][1]);
                    } else {
                        Node node3 = new Node(1, time++);
                        count.put(operators[i][1], node3);
                        minHeap.offer(operators[i][1]);
                    }

                }
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}

class Node {
    public Integer count;
    public Integer time;

    public Node(Integer count, Integer time) {
        this.count = count;
        this.time = time;
    }
}