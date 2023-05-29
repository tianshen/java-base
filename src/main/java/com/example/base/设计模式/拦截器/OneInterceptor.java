package com.example.base.设计模式.拦截器;

/**
 *
 * @author eunhye
 */
public class OneInterceptor implements Interceptor{

    @Override
    public String intercept(String url) {
        return "one";
    }
}
