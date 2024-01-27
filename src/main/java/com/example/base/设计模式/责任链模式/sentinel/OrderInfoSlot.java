package com.example.base.设计模式.责任链模式.sentinel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderInfoSlot extends AbstractLinkedProcessorSlot<PaymentContext> {

    @Override
    public void processHandler(PaymentContext param) {
        if(param != null){
            log.info("查询订单信息开始.....");
            param.setOrderId("123456789");
            param.setMerchantOrderId("aksdhajsdfhsaidf");
        }
    }
}