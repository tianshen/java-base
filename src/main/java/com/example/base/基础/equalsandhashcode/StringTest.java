package com.example.base.基础.equalsandhashcode;

public class StringTest {

    public static void main(String[] args) {

        String s = new String("111");
        String s1 = new String("111");
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());

        Integer i = new Integer(12);
        int hashCode = i.hashCode();
        System.out.println(hashCode);


    }
}
