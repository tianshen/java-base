package com.example.base.值传递和引用传递;

public class Test {

    private static int a = 100;

    public static void main(String[] args) {
        a = 200;
        Integer s = 10;
        int intValue = s.intValue();
        System.out.println(a);
    }

}
