package com.example.base.设计模式.责任链模式.sentinel;

public class BeforeSlotChainBuilderImpl implements SlotChainBuilder<ProcessorSlotChain> {



    @Override
    public ProcessorSlotChain build() {

        ProcessorSlotChain processorSlotChain = new DefaultProcessorSlotChain();

        processorSlotChain.addLast(new OrderInfoSlot());
        processorSlotChain.addLast(new RiskSlot());
        processorSlotChain.addLast(new MarketingSlot());

        return processorSlotChain;
    }
}