package com.example.base.数据结构和算法.书籍.队列.链表实现队列;

public class LinkedListToQueue {

    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V v) {
            value = v;
        }
    }

    public static class MyQueue<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offer(V value) {
            Node<V> cur = new Node<>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public V poll() {
            V ans = null;
            if (head == null) {
                tail = null;
            }
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }


    }
}
