package com.example.base.设计模式.适配器模式.简单;

public class AppTest {

    public static void main(String[] args) {

        Calc calc = new Calc();
        CalcAdapter calcAdapter = new CalcAdapter(calc);
        int r = calcAdapter.add(1, 2, 3);
        System.out.println(r);
    }
}
