package com.example.base.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedissonLockService {

    @Autowired
    private Redisson redisson;

    public void setLock(){
        int waitTime = 500;
        int leaseTime = 1000;
        String lockKey = "redisKey";
        //获取锁对象
        RLock redissonLock = redisson.getLock(lockKey);

        try  {
            boolean b = redissonLock.tryLock(waitTime, leaseTime, TimeUnit.MILLISECONDS);
            if (b) {
                System.out.println(" ");
            }
        } catch (Exception e) {

        } finally {
            redissonLock.unlock();
        }


        try {
            /**
             * 有并发安全问题的业务逻辑
             */
        } finally {
            redissonLock.unlock();
        }
    }
}
