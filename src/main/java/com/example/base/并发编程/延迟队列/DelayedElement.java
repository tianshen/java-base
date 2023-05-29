package com.example.base.并发编程.延迟队列;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed {

    /**
     * 你的电话要排队等的时间 比如你等了 60秒还没人接 这个就是等待时间 延迟时间
     */
    private final long delay;
    /**
     * 到期时间
     */
    private final long expire;
    /**
     * 数据
     */
    private final String msg;
    /**
     * 你的电话进入排队的时间 创建时间
     */
    private final long now;

    public DelayedElement(long delay, String msg) {
        this.delay = delay;
        this.msg = msg;
        // 到期时间 = 当前时间+延迟时间
        expire = System.currentTimeMillis() + delay;
        now = System.currentTimeMillis();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DelayedElement{");
        sb.append("delay=").append(delay);
        sb.append(", expire=").append(expire);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", now=").append(now);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 需要实现的接口，获得延迟时间   用过期时间-当前时间
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 用于延迟队列内部比较排序   当前时间的延迟时间 - 比较对象的延迟时间
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }
}