package com.example.base.设计模式.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyHandler implements InvocationHandler {

    private Calculator calculator;

    public MyHandler(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "开始，参数：" + Arrays.toString(args));
        System.out.println(method.getName() + "结束，结果是：" + method.invoke(calculator, args));
        return method.invoke(calculator, args);
    }
}
