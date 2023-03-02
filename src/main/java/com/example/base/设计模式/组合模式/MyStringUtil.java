package com.example.base.设计模式.组合模式;

public class MyStringUtil {
    public static String repeatString(String repeatStr, int repeatNum) {
        StringBuilder stringBuilder = new StringBuilder();
        while (repeatNum-- > 0) {
            stringBuilder.append(repeatStr);
        }
        return stringBuilder.toString();
    }
}