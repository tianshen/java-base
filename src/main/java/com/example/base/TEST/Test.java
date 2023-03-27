package com.example.base.TEST;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

//        List<Person> personList = Lists.newArrayList();
//        personList.add(new Man());
//        personList.add(new Woman());
//
//        for (Person person : personList) {
//            if (person instanceof Person) {
//                System.out.println("yes");
//            }
//        }


        // Man man = new Man();
        // System.out.println(man instanceof Person);


        Man man1 = new Man();
        man1.setName("maomao");
        Man man2 = new Man();
        man2.setName("name");

        System.out.println(man1);
        System.out.println(man2);

        man2 = man1;
        System.out.println(man2);



    }
}
