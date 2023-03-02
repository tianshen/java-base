package com.example.base.JAVA8_LAMBDA.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppTest {

    public static void main(String[] args) {

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("");
        list.add("c");
        list.add("d");
        list.add("");
        list.add("e");
        List<String> filter = filter(list, nonEmptyStringPredicate);
        for (String s : filter) {
            System.out.println(s);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
