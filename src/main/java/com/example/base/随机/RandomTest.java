package com.example.base.随机;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {

        Random random = new Random();
        int nextInt = random.nextInt(1);
        System.out.println(nextInt);

        int i = 20 / 100;
        System.out.println(i);

        int i2 = 40 / 41;
        System.out.println(i2);

        int i1 = 20 % 21;
        System.out.println(i1);

        int i3 = 0 / 20;
        System.out.println(i3);


        int max = 20;
        int min = 0;
        int s = random.nextInt(max)%(max-min+1) + min;
        System.out.println(s);

    }

}
