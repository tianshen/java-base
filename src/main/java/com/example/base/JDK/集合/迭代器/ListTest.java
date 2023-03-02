package com.example.base.JDK.集合.迭代器;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        // 浅拷贝 深拷贝

        List<String> list = Lists.newArrayList();
        list.add("111");
        list.add("222");
        list.add("333");
        System.out.println(list.toString());
        Collections.reverse(list);
        System.out.println(list.toString());
    }
}
