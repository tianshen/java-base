package com.example.base.redis.lock;

public interface RedLock {

    void lock(String resource) throws InterruptedException;

    void unlock(String resource);
}