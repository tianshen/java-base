package com.example.base;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisTest {

    public static void main(String[] args) {

        List<UserTest> lists = Lists.newArrayList();
        UserTest userTest = new UserTest();
        userTest.setName("11");
        UserTest userTest2 = new UserTest();
        userTest2.setName("11");
        UserTest userTest3 = new UserTest();
        userTest3.setName("22");
        UserTest userTest4 = new UserTest();
        userTest4.setName("22");

        lists.add(userTest);
        lists.add(userTest2);
        lists.add(userTest3);
        lists.add(userTest4);

        List<String> names = lists.stream().map(UserTest::getName).distinct().collect(Collectors.toList());
        System.out.println(names);

    }
}
