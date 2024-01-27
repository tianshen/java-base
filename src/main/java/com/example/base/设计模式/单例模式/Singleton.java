package com.example.base.设计模式.单例模式;

public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    /**
     * 单利模式 双重检索
     *
     * @return
     */
    public static Singleton getSingleton() {
        // 双重检索
        if (singleton == null) {
            // 解决并发问题
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    // 双重检索  恶汉模式
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}