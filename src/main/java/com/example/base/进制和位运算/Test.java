package com.example.base.进制和位运算;

public class Test {

    public static void main(String[] args) {

        int num = 6;
        if ((num & 2) == 2) {
            System.out.println("1111");
        } else {
            System.out.println("2222");
        }


        int i = 511 & 511;
        System.out.println(i);

        int i1 = 2 / 512;
        System.out.println(i1);

    }
}
