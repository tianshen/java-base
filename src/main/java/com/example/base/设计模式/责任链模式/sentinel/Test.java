package com.example.base.设计模式.责任链模式.sentinel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

    public static void main(String[] args) {
        //新建一个支付前责任链
        BeforeSlotChainBuilderImpl beforeSlotChainBuilder = new BeforeSlotChainBuilderImpl();

        PaymentContext context = new PaymentContext();
        beforeSlotChainBuilder.build().process(context);

        log.info(context.toString());


    }
}