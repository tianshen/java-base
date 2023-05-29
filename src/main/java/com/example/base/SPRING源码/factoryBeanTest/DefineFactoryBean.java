package com.example.base.SPRING源码.factoryBeanTest;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class DefineFactoryBean implements FactoryBean<IHelloService> {

    /**
     * 生成代理对象
     * @return
     */
    @Override
    public IHelloService getObject() {
        IHelloService helloService = (IHelloService) Proxy.newProxyInstance(IHelloService.class.getClassLoader(),
                new Class<?>[]{IHelloService.class},
                (proxy, method, args) -> {
                    System.out.println("begin execute");
                    return "Hello FactoryBean";
                });
        return helloService;
    }

    @Override
    public Class<?> getObjectType() {
        return IHelloService.class;
    }
}