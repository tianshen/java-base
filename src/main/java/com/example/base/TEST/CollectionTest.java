package com.example.base.TEST;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionTest {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>();

        /**
         * 指定list的大小
         */
        List<String> arrayList = new ArrayList<>(100);
        // 返回一个迭代器
        Iterator<String> iterator = arrayList.iterator();
        // hasNext   next   remove
        boolean b = iterator.hasNext();
        // 提供了更多的方法 双向遍历 添加元素 修改元素  获取元素索引  使用范围
        ListIterator<String> listIterator = arrayList.listIterator();

        /**
         * 线程安全的list
         */
        List<String> synchronizedList = Collections.synchronizedList(list);
        Stack<String> stack = new Stack<>();


        // hashSet是基于哈希表实现的 基于hashMap实现的
        Set<String> hashSet = new HashSet<>();
        boolean add = hashSet.add("1");
        // 判断元素是否存在
        boolean contains = hashSet.contains("1");

        // LinkedHashSet是在 HashSet 的基础上，增加了链表来保证元素的插入顺序
        // 基于linkedHashMap实现
        // linkedHashMap基于hashMap实现的，只是在hashMap基础上增加了一个双向链表，这个双向链表连接了所有的键值对，定义了键值对的迭代顺序，这个顺序可以是插入顺序，也可以是访问顺序。
        // 有序的 通过双向链表实现的
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // TreeSet 是基于红黑树实现的，元素会按照自然顺序或者自定义的顺序进行排序
        TreeSet<String> treeSet = new TreeSet<>();


        TreeMap<String, String> treeMap = new TreeMap<>();

        // 写时复制 读操作不加锁，写操作加锁  适用于读多写少的场景
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();



        // 什么是fail fast（快速失败） 一个错误检查机制  “Fail Fast” 的主要目的是为了快速发现并发修改的问题，而不是等到程序运行一段时间后才发现问题
        // 什么是fail safe（安全失败）
        // ConcurrentModificationException
        // 可以使用 Iterator 的 remove()



        // 为什么使用 Iterator 删除元素更加安全？   1、避免发生修改异常  concurrentModificationException  2、数组越界的问题


        // java8中的stream怎么理解？

    }
}
