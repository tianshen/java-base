package com.example.base.并发编程.线程池实现示例;

import java.util.function.Supplier;

public class ThreadPoolTest {

    public static void main(String[] args) {

        DefaultThreadPool<Supplier> pool = new DefaultThreadPool<>();
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "在执行");
            }
        };

        Supplier<String> supplier = () -> "你好";
        pool.execute(supplier);
    }
}
