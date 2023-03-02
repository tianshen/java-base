package com.example.base.JAVA8_LAMBDA.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class AppTest {

    public static void main(String[] args) {

        List<Integer> list = map(Arrays.asList("lambda", "in", "action"), String::length);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
