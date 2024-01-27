package com.example.base.基础.equalsandhashcode;

import lombok.Data;

@Data
public class ObjectTest {
    public static void main(String[] args) {


        User user = new User("mao", "男");
        User user1 = user;
//        user1.setName("mi");
//        user1.setSex("女");
        System.out.println(user == user1);
        System.out.println(user.equals(user1));
        System.out.println(HashUtil.hash(user));
        System.out.println(HashUtil.hash(user1));

        System.out.println("---------------------------------------------");


        User user3 = new User("na", "女");
        User user4 = new User("na", "女");
        System.out.println(user3 == user4);
        System.out.println(user3.equals(user4));
        System.out.println(HashUtil.hash(user3));
        System.out.println(HashUtil.hash(user4));




    }
}
