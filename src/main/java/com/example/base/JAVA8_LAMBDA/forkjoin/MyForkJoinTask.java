package com.example.base.JAVA8_LAMBDA.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * MyForkJoinTask
 * @author senfel
 * @version 1.0
 * @date 2023/3/23 14:07
 */
public class MyForkJoinTask extends RecursiveTask<Integer> {

    /**
     * 开始元素
     */
    private Integer startElement;
    /**
     * 结束元素
     */
    private Integer endElement;


    public MyForkJoinTask(Integer startElement, Integer endElement) {
        this.startElement = startElement;
        this.endElement = endElement;
    }

    /**
     * compute
     * @author senfel
     * @date 2023/3/23 14:08
     * @return java.lang.Integer
     */
    @Override
    protected Integer compute() {
        int result = 0;
        if(startElement > endElement){
            int temp = endElement;
            endElement = startElement;
            startElement = temp;
        }
        //间隔两个数之内不进行拆分
        if(endElement - startElement <= 2){
            for(int i = endElement;i >= startElement;i--) {
                result += i;
            }
        }else{
            //获取两个数中间值
            int middle = (endElement + startElement) / 2;
            MyForkJoinTask taskByLeft = new MyForkJoinTask(startElement, middle);
            MyForkJoinTask taskByRight = new MyForkJoinTask(middle+1, endElement);
            //执行子任务
            taskByLeft.fork();
            taskByRight.fork();
            //等待子任务完成
            Integer joinByLeft = taskByLeft.join();
            Integer joinByRight = taskByRight.join();
            result = joinByLeft+joinByRight;
        }
        return result;
    }
}