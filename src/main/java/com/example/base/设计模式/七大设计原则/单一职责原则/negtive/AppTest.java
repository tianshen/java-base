package com.example.base.设计模式.七大设计原则.单一职责原则.negtive;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 * 统计一个文本文件中有多少单词
 */

public class AppTest {

    @SneakyThrows
    public static void main(String[] args) {

        Reader in = new FileReader("F:\\1.txt");
        BufferedReader br = new BufferedReader(in);

        String line = null;

        StringBuilder sb = new StringBuilder("");

        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(" ");
        }

        //通过正则表达式切割
        String[] words = sb.toString().split("[^a-zA-Z]+");

        for (String word : words) {
            System.out.println(word);
        }

        System.out.println(words.length);

        in.close();
        br.close();

    }
}
