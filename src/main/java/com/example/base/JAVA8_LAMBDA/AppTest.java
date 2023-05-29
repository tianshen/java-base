package com.example.base.JAVA8_LAMBDA;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

/**
 * 函数式接口
 */
public class AppTest {

    public static void main(String[] args) {


//        Runnable r1 = () -> System.out.println("Hello world 01");
//
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello world 02");
//            }
//        };
//
//        process(r1);
//        process(r2);
//        process(() -> System.out.println("Hello world 03"));

        ForkJoinPool forkJoinPool = new ForkJoinPool(8);





        Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .forEach((value) -> {
                    String name = Thread.currentThread().getName();
                    System.out.println("示例1 Thread:" + name + " value:" + value);
                });

        System.out.println("===========================================");

        Stream.of(1, 2, 3, 4, 5, 6)
                .parallel()
                .forEach((value) -> {
                    String name = Thread.currentThread().getName();
                    System.out.println("示例2 Thread:" + name + " value:" + value);
                });

    }

//    public static void process(Runnable runnable) {
//        runnable.run();
//    }


}
