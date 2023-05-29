package com.example.base.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedissonLockService {

    @Autowired
    private Redisson redisson;

    public void setLock(){
        String lockKey = "redisKey";
        //获取锁对象
        RLock redissonLock = redisson.getLock(lockKey);
        redissonLock.lock();
        try {
            /**
             * 有并发安全问题的业务逻辑
             */
        } finally {
            redissonLock.unlock();
        }
    }
}
