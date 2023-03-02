package com.example.base.构造函数;

public class Test {

    public Test() {

    }

    public Test(String a) {

    }

    public static void main(String[] args) {
        Test test = new Test();
        Test test1 = new Test("11");
        test.equals(test1);

        String s = "11";
        s.equals("11");

    }
}
