package com.example.base.JDK源码阅读.集合.迭代器;

import java.util.concurrent.locks.ReentrantLock;

public class JucTest {

    public void test() {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.tryLock();
    }
}
