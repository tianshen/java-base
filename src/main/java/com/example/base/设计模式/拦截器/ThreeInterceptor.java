package com.example.base.设计模式.拦截器;

/**
 * @author xue
 * @date 2023/4/7 1:14
 */
public class ThreeInterceptor implements Interceptor{

    @Override
    public String intercept(String url) {
        return "three";
    }
}
