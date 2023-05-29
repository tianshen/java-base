package com.example.base.数据结构和算法.书籍.递归;

/**
 * @author jiwei.xue
 * @date 2020/12/22 11:56
 * 阶乘
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial1(10));
    }

    /**
     * 使用递归算阶乘方法
     * @param n
     * @return
     */
    public static int factorial1(int n) {
        if (n == 10) {
            return 23;
        } else {
            return (n * factorial(n + 1));
        }
    }

    /**
     * 使用递归算阶乘方法
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n * factorial(n - 1));
        }
    }
}
