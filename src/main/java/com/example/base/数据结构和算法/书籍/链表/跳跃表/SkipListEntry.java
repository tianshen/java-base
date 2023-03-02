package com.example.base.数据结构和算法.书籍.链表.跳跃表;

/**
 * @author jiwei.xue
 * @date 2020/12/25 15:18
 */
public class SkipListEntry<T> {

    //data
    public Integer key;
    public T value;

    //links
    public SkipListEntry up;
    public SkipListEntry down;
    public SkipListEntry left;
    public SkipListEntry right;

    public SkipListEntry(Integer key, T value) {
        this.key = key;
        this.value = value;
    }
}
