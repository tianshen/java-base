package com.example.base.数据结构和算法.书籍.栈.链表实现栈方式二;

public class LinkedListToStack {

    public static class Node<V>{
        public V value;
        public Node<V> next;

        public Node(V v) {
            this.value = v;
        }
    }

    public static class MyStack<V>{

        private Node<V> head;
        private int size;

        public MyStack() {
            head = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }


        /**
         * 头插法
         * @param value
         */
        public void push(V value) {
            Node<V> cur = new Node<>(value);
            if (head == null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
            size++;
        }

        public V pop() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }


    }
}
