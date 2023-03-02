package com.example.base.设计模式.七大设计原则.单一职责原则.positive;

import lombok.SneakyThrows;

import java.io.*;

/**
 * 单一职责原则
 * 1、提高代码的重用性
 * 2、代码的可读性提高了 此时的代码就像一个大纲一样
 * 统计一个文本文件中有多少单词
 */

public class AppTest {
    @SneakyThrows
    public static void main(String[] args) {

        // 加载文件
        String str = loadFile("F:\\1.txt");

        //通过正则表达式切割
        String[] words = getStrings(str);

        System.out.println(words.length);

    }

    private static String loadFile(String path) throws IOException {
        Reader in = new FileReader(path);
        BufferedReader br = new BufferedReader(in);

        String line;

        StringBuilder sb = new StringBuilder("");

        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(" ");
        }

        in.close();
        br.close();
        return sb.toString();
    }

    private static String[] getStrings(String str) {
        return str.split("[^a-zA-Z]+");
    }
}
