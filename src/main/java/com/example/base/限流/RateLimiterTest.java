package com.example.base.限流;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

    public static void main(String[] args) {

        RateLimiter rateLimiter = RateLimiter.create(5.0d);
        boolean b = rateLimiter.tryAcquire();


    }
}
