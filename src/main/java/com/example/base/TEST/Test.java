package com.example.base.TEST;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Person> personList = Lists.newArrayList();
        personList.add(new Man());
        personList.add(new Woman());

        for (Person person : personList) {
            if (person instanceof Person) {
                System.out.println("yes");
            }
        }


        // Man man = new Man();
        // System.out.println(man instanceof Person);
    }
}
