package com.example.base.JAVA8_LAMBDA.使用流;

import java.util.Arrays;
import java.util.List;

public class AppTest {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 4, 2, 4, 6);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
