package com.example.base.设计模式.适配器模式.简单;

public class CalcAdapter {

    private Calc calc;

    public CalcAdapter(Calc calc) {
        this.calc = calc;
    }

    public int add(int a, int b, int c) {
        int r = calc.add(a, b) + c;
        return r;
    }
}
