package com.example.base.设计模式.责任链模式.momo任务体系;

import lombok.Data;

@Data
public class JoinTaskTypeInfo {

    /**
     * topic
     */
    private String topic;

    /**
     * moa回调的url
     */
    private String serviceUrl;

    /**
     * moa回调的方法
     */
    private String methodName;

    /**
     * 下一阶段任务类型
     */
    private String nextTaskType;

    /**
     * 延时时间
     */
    private long nextDelayTime;

    /**
     * 下一阶段任务回调的条件
     */
    private NextTaskGoBackCondition condition;
}
