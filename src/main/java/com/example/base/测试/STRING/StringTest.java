package com.example.base.测试.STRING;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
        String photo = "7713F613-B81C-7856-EFE2-650DED73FE3320210309";
        String format = String.format("https://img.momocdn.com/album/%s/%s/%s_S.jpg", photo.substring(0, 2), photo.substring(2, 4), photo);
        System.out.println(format);


        List<Integer> ss = Lists.newArrayList();
        ss.add(1);
        ss.add(2);
        ss.add(3);
        ss.add(4);
        List<Integer> integers = ss.subList(0, 3);
        System.out.println(integers.toString());
    }

}
