package com.example.base.JAVA8_LAMBDA.环绕执行模式;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppTest {

    public static void main(String[] args) throws IOException {
        String file = processFile((BufferedReader bufferedReader) -> bufferedReader.readLine() + bufferedReader.readLine());
        System.out.println(file);
    }

    public static String processFile (BufferedReaderProcessor p) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\1.txt"));
        return p.process(bufferedReader);
    }
}
