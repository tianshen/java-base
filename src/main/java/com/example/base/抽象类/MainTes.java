package com.example.base.抽象类;

public class MainTes {

    public static void main(String[] args) {

        new AbsTest(){
            @Override
            public void test() {
                super.test();
            }
        };

    }
}
