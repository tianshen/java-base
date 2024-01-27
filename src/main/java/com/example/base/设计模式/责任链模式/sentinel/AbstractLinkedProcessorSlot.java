package com.example.base.设计模式.责任链模式.sentinel;

public abstract class AbstractLinkedProcessorSlot<T> implements ProcessorSolt<T> {

    /**
     * 设置链的下一个触发的组件
     */
    private AbstractLinkedProcessorSlot<T> next = null;

    @Override
    public void fireProcess(T param) {
        if(next != null){
            //触发下一个节点执行
            next.process(param);
        }
    }

    public AbstractLinkedProcessorSlot<T> getNext() {
        return next;
    }

    public void setNext(AbstractLinkedProcessorSlot<T> next) {
        this.next = next;
    }

    @Override
    public void process(T param) {

        processHandler(param);
        //触发下一个节点进行
        fireProcess(param);

    }

    /**
     * 定义钩子，是业务逻辑实际处理的实现
     * @param param
     */
    public abstract void processHandler(T param);
}