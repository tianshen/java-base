package com.example.base.JDK.集合.迭代器;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("name", "jiwei");
        Set<String> set = map.keySet();
        System.out.println("...");
        for(String s : set) {
            System.out.println(s);
        }
    }
}
