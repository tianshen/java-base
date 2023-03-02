//package com.example.base;
//
//import com.google.common.base.Strings;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Test {
//
//    public static void main(String[] args) {
//        String s = "1.2.3.4";
//        int i = converInt(s);
//        System.out.println(i);
//    }
//
//    public static int converInt(String s) {
//        if (s == null) {
//            return 0;
//        }
//
//        String[] strings = s.split("\\.");
//        //List<Integer> numbles = new ArrayList<>();
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        int total = 0;
//        for (int i = 3; i >= 0; i--) {
//            int parseInt = Integer.parseInt(strings[i]);
//            hashMap.put(parseInt, (Integer)Math.pow(Double.valueOf(parseInt), Double.valueOf(i)));
//        }
//        for (Map.Entry entry : hashMap.entrySet()) {
//            total += (Integer) entry.getKey() * (Integer) entry.getValue();
//        }
//        return total;
//    }
//}
