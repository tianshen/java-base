package com.example.base.重试;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @author xue
 * @date 2023/5/14 16:14
 */
public class RetryListener01 implements RetryListener {
    @Override
    public <V> void onRetry(Attempt<V> attempt) {
        System.out.println(attempt.getResult());
    }
}
