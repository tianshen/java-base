package com.example.base.设计模式.责任链模式.sentinel;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class PaymentContext implements Serializable {

    private String orderId;

    private String merchantOrderId;

    private String riskId;

    private boolean passRisk;

    private Map<String,String> marketInfoMap;
}