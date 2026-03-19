package com.example.base;

public class Test1 {

    /**
     * 斐波那契函数 递归实现
     * @param n
     * @return
     */
    public static int test (int n) {
        if (n < 2) {
            return n;
        }
// /*  */
        return test(n - 1) + test(n - 2);
    }

}
