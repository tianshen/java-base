package com.example.base.设计模式.责任链模式.sentinel;

public abstract class ProcessorSlotChain<T> extends AbstractLinkedProcessorSlot<T> {


    /**
     * 添加到下一个触发节点
     * @param processorSlot
     */
    public abstract void addLast(AbstractLinkedProcessorSlot<T> processorSlot);
}