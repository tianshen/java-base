package com.example.base;

public class Test1 {

    public static int test (int n) {
        if (n < 2) {
            return n;
        }

        return test(n - 1) + test(n - 2);
    }

}
