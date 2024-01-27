package com.example.base.设计模式.责任链模式.sentinel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RiskSlot extends AbstractLinkedProcessorSlot<PaymentContext> {


    @Override
    public void processHandler(PaymentContext param) {
        if(param != null) {
            log.info("报送风控开始......");
            param.setRiskId("0987689900");

            param.setPassRisk(true);
        }

    }
}