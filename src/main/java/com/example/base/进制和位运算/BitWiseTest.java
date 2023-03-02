package com.example.base.进制和位运算;

public class BitWiseTest {

    public static void main(String[] args) {

        // 与运算    两个都为1 才是1
//        int a = 128;
//        int b = 129;
//        String aBinary = Integer.toBinaryString(a);
//        System.out.println(aBinary);
//        String bBinary = Integer.toBinaryString(b);
//        System.out.println(bBinary);
//        int i = a & b;
//        String iBinary = Integer.toBinaryString(i);
//        System.out.println(iBinary);
//        System.out.println("a和b 与的结果是：" + i);

        // 或运算  只要有一个为1，就是1
//        int a = 128;
//        int b = 129;
//        String aBinary = Integer.toBinaryString(a);
//        System.out.println(aBinary);
//        String bBinary = Integer.toBinaryString(b);
//        System.out.println(bBinary);
//        int i = a | b;
//        String iBinary = Integer.toBinaryString(i);
//        System.out.println(iBinary);
//        System.out.println("a和b 或的结果是：" + i);

        // 非运算
//        int a = 2;
//        String aBinary = Integer.toBinaryString(a);
//        System.out.println(aBinary);
//        int i = ~ a;
//        String iBinary = Integer.toBinaryString(i);
//        System.out.println(iBinary);
//        System.out.println("a 非的结果是：" + i);

        //异或运算
//        int a = 15;
//        int b = 2;
//        String aBinary = Integer.toBinaryString(a);
//        System.out.println(aBinary);
//        String bBinary = Integer.toBinaryString(b);
//        System.out.println(bBinary);
//        int i = a ^ b;
//        String iBinary = Integer.toBinaryString(i);
//        System.out.println(iBinary);
//        System.out.println("a和b 异或的结果是：" + i);

//        int x = 2;
//        System.out.println(Integer.toBinaryString(x));   //0000 0010
//        int i = x << 3;
//        System.out.println(Integer.toBinaryString(i));   //0001 0000
//        System.out.println("x的向左移动3位的结果：" + i);


        int x = 8;
        System.out.println(Integer.toBinaryString(x));   //0000 1000
        int i = x >> 3;
        System.out.println(Integer.toBinaryString(i));   //0000 0001
        System.out.println("x的向右移动3位的结果：" + i);

    }

}
