package com.example.base.JAVA8_LAMBDA;

/**
 * 函数式接口
 */
public class AppTest {

    public static void main(String[] args) {


        Runnable r1 = () -> System.out.println("Hello world 01");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 02");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello world 03"));
    }

    public static void process(Runnable runnable) {
        runnable.run();
    }
}
