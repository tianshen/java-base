package com.example.base.SPRING源码.factoryBeanTest;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class GpImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 注册BeanDefinition
     *
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {

        DefineFactoryBean factoryBean = new DefineFactoryBean();
        BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(
                IHelloService.class, () -> factoryBean.getObject());
        BeanDefinition beanDefinition = definition.getBeanDefinition();
        registry.registerBeanDefinition("helloService", beanDefinition);
    }
}