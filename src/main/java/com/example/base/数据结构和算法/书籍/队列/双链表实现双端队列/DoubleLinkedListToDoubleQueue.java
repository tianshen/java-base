package com.example.base.数据结构和算法.书籍.队列.双链表实现双端队列;

import com.example.base.数据结构和算法.书籍.队列.链表实现队列.LinkedListToQueue;

public class DoubleLinkedListToDoubleQueue {

    public static class Node<V> {
        public V value;
        public Node<V> next;
        public Node<V> last;

        public Node(V v) {
            value = v;
            next = null;
            last = null;
        }

        public static class MyQueue<V> {
            public Node<V> head;
            public Node<V> tail;
            public int size;

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

            public void pushHead(V value) {
                Node<V> cur = new Node<>(value);
                if (head == null) {
                    head = cur;
                    tail = cur;
                } else {
                    cur.next = head;
                    head.last = cur;
                    head = cur;
                }
                size++;
            }

            public void pushTail(V value) {
                Node<V> cur = new Node<>(value);
                if (tail == null) {
                    head = cur;
                    tail = cur;
                } else {
                    tail.next = cur;
                    cur.last = tail;
                    tail = cur;
                }
                size++;
            }

            public V pollHead() {
                V ans = null;
                if (head == null) {
                    return ans;
                }
                size--;
                ans = head.value;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.last = null;
                }
                return ans;
            }

            public V pollLast() {
                V ans = null;
                if (tail == null) {
                    return ans;
                }
                size--;
                ans = tail.value;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    tail = tail.last;
                    tail.next = null;
                }
                return ans;
            }

        }
    }

    public static void main(String[] args) {


    }
}
