package com.example.base.并发编程.线程;

import java.util.concurrent.TimeUnit;

public class InterruptDemo04 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                System.out.println(i);
            }
            // System.out.println(Thread.currentThread().getName() + "线程调用interrupt()方法后的中断状态02：" + Thread.currentThread().isInterrupted());
        }, "t1");
        thread.start();
        System.out.println(thread.getName() + "线程默认的中断状态：" + thread.isInterrupted());
 
        TimeUnit.MILLISECONDS.sleep(2);
 
        // 主线程请求中断t1线程
        // interrupt()并不能真正的停止线程，只是更换了线程中断状态标志位。
        thread.interrupt();
 
        // isInterrupted(): 实例方法。测试此线程是否已中断。线程的中断状态不受此方法的影响。（即不会清除线程的中断状态）
        System.out.println(thread.getName() + "线程调用interrupt()方法后的中断状态01：" + thread.isInterrupted());
 
 
        TimeUnit.SECONDS.sleep(3);
        // 中断一个不活动的线程，不会产生任何影响。所以输出为false. （3秒后t1线程早就执行完了。）
        System.out.println(thread.getName() + "线程调用interrupt()方法后的中断状态03：" + thread.isInterrupted());
    }
}
