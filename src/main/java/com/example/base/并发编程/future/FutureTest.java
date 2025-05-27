package com.example.base.并发编程.future;

import java.util.concurrent.*;

public class FutureTest {

    public static class ImplCallable implements Callable {
        @Override
        public Object call() throws Exception {
            return "我是实现了Callable的一个线程";
        }
    }

    public static class ImplRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("我是实现了Callable的一个线程");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new ImplCallable());
        String sss = (String) future.get();


        System.out.println(sss);



        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("通过Callable方式执行任务");
                Thread.sleep(300000);
                return "返回任务结果";
            }
        });

        new Thread(task).start();


        Object o = task.get();
        System.out.println(o);


    }
}
