package com.example.base.设计模式.拦截器;

/**
 * @author: xue
 * @date: 2023/4/7 1:12
 */
public class TwoInterceptor implements Interceptor{

    @Override
    public String intercept(String url) {
        return "two";
    }
}
