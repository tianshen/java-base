package com.example.base.数据结构和算法.书籍.递归;

/**
 * @author jiwei.xue
 * @date 2020/12/22 11:38
 */
public class Triangle {

    public static void main(String[] args) {
        System.out.println(whileTriangle(100));
        System.out.println(recursiveTriangle(100));

    }

    /**
     * 循环获取三角形总和
     *
     * @param n
     * @return
     */
    public static int whileTriangle(int n) {
        int total = 0;
        while (n > 0) {
            total = total + n;
            --n;
        }
        return total;
    }

    /**
     * 递归获取三角形的总和
     * @param n
     * @return
     */
    public static int recursiveTriangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (n + recursiveTriangle(n - 1));
        }
    }
}
