package com.example.base.设计模式.拦截器;

import org.assertj.core.util.Lists;

import java.util.List;

public class TestTemplate {

    List<Interceptor> interceptorList = Lists.newArrayList();

    public String execute() {

        System.out.println("执行execute");
        return "success";
    }
}
