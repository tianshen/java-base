package com.example.base.抽象类;

public abstract class AbsTest {

    public void test() {
        System.out.println("test");

    }

    public abstract void test2();

    public void test3() {
        System.out.println("test3");    
    }

    public static void main(String[] args) {
        AbsTest absTest = new AbsTest() {
            @Override
            public void test2() {
                System.out.println("test2");
            }
        };
    }
}
