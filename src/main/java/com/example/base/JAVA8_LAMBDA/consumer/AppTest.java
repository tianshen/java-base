package com.example.base.JAVA8_LAMBDA.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class AppTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d", "f");
        Consumer<String> c = System.out::print;
        forEach(list, c);
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
