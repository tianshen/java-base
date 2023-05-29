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