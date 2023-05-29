package com.example.base.设计模式.拦截器;

/**
 * @author eunhye
 */
@FunctionalInterface
public interface Interceptor {

    /**
     * 拦截业务逻辑
     * @param url
     * @return
     */
    String intercept(String url);
}
