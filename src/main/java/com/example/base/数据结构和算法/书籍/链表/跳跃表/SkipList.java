package com.example.base.数据结构和算法.书籍.链表.跳跃表;

import java.util.Random;

/**
 * @author jiwei.xue
 * @date 2020/12/25 15:21
 * 高效的查找算法： 有序数组   二叉查找数   平 衡二叉树    跳跃表
 * 跳跃表： 缺点是存在一定的数据冗余，达到以空间换时间的目的
 * 特征：
 *      1、一个跳跃表应该有若干个层（Level）链表组成；
 *      2、跳跃表中最底层的链表包含所有数据； 每一层链表中的数据都是有序的；
 *      3、如果一个元素 X 出现在第i层，那么编号比 i 小的层都包含元素 X；
 *      4、第 i 层的元素通过一个指针指向下一层拥有相同值的元素；
 *      5、在每一层中，-∞ 和 +∞ 两个元素都出现(分别表示 INT_MIN 和 INT_MAX)；
 *      6、头指针（head）指向最高一层的第一个元素；
 */
public class SkipList {

    public int n;

    public int h;

    public SkipListEntry head;

    public SkipListEntry tail;
    public Random r;

    /**
     * 构造函数
     */
    public SkipList() {
        //创建head节点
        this.head = new SkipListEntry(Integer.MIN_VALUE, null);
        //创建tail节点
        this.tail = new SkipListEntry(Integer.MAX_VALUE, null);

        //将head节点的右指针指向tail节点
        this.head.right = tail;
        //将tail节点的左指针指向head节点
        this.tail.left = head;

        this.h = 0;
        this.n = 0;
        this.r = new Random();
    }

    /**
     * @param key
     * @return
     */
    public SkipListEntry findEntry(Integer key) {
        // 从头节点开始查找
        SkipListEntry p = head;
        while (true) {
            while (p.right.key <= key) {
                p = p.right;
            }

            if (p.down != null) {
                p = p.down;
            } else {
                break;
            }
        }
        //返回p，！ 注意 这里p的key值是小于等于传入key的值的 （p.key <= key）
        return p;
    }

    /**
     * @param key
     * @return
     */
    public Object get(Integer key) {
        SkipListEntry p = findEntry(key);
        if (p.key.equals(key)) {
            return p.value;
        } else {
            return null;
        }
    }

    public Object put(Integer key, Object value) {
        SkipListEntry p, q;
        int i = 0;

        //查找适合插入的位置
        p = findEntry(key);

        //如果跳跃表中存在含有key值得节点，则进行value得修改操作即可完成
        if (p.key.equals(key)) {
            Object oldValue = p.value;
            p.value = value;
            return oldValue;
        }

        // 如果跳跃表中不存在含有key值得节点，则进行新增操作
        q = new SkipListEntry(key, value);

        // 添加节点，给节点赋值
        q.left = p;
        q.right = p.right;
        p.right.left = q;
        p.right = q;

        //再使用随机数决定是否要向更高得level攀升
        while (r.nextDouble() < 0.5) {
            //如果新元素得级别已经达到跳跃表得最大高度，则新建空白层
            if (i >= h) {
                addEmptyLevel();
            }

            // 从p向左扫描含有高层节点的节点
            while (p.up == null) {
                p = p.left;
            }

            p = p.up;

            // 新增和q指针指向的节点含有相同key值的节点对象
            // 这里需要注意的是除底层节点之外的节点对象是不需要value值的
            SkipListEntry z = new SkipListEntry(key, null);
            z.left = p;
            z.right = p.right;
            p.right.left = z;
            p.right = z;

            z.down = q;
            q.up = z;

            q = z;
            i = i + 1;
        }
        n = n + 1;

        //返回null， 没有旧节点的value值
        return null;
    }


    /**
     * 添加新的一层
     */
    public void addEmptyLevel() {
        SkipListEntry p1 = new SkipListEntry(Integer.MIN_VALUE, null);
        SkipListEntry p2 = new SkipListEntry(Integer.MAX_VALUE, null);
        p1.right = p2;
        p1.down = head;
        p2.left = p1;
        p2.down = tail;
        head.up = p1;
        tail.up = p2;
        head = p1;
        tail = p2;
        h++;
    }

    public Object remove(Integer key) {
        SkipListEntry p, q;
        p = findEntry(key);

        if (!p.key.equals(key)) {
            return null;
        }

        Object oldValue = p.value;
        while (p != null) {
            q = p.up;
            p.left.right = p.right;
            p.right.left = p.left;
            p = q;
        }
        return oldValue;
    }

}
