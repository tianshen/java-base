package com.example.base.设计模式.责任链模式.sentinel;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MarketingSlot extends AbstractLinkedProcessorSlot<PaymentContext> {

    @Override
    public void processHandler(PaymentContext param) {
        if (param != null) {
            log.info("##开始查询营销信息.......");

            if (param.isPassRisk()) {
                //如果风控校验通过的化
                Map<String, String> map = new HashMap<>();
                map.put("discountAmt", "200");
                map.put("showDesc", "满2块减1块");
                param.setMarketInfoMap(map);
            }else{
                log.info("##风控没有通过，不能查询营销信息");
            }
        }

    }
}