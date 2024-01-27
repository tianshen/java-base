package com.example.base.基础.object;

import java.lang.reflect.Field;

public class ObjectTest {

    public static void main(String[] args) {


        User user = new User();
        String name = user.getName();
        System.out.println(name);
        Class<? extends User> aClass = user.getClass();
        System.out.println(aClass);
        Field[] fields = aClass.getFields();



    }
}
