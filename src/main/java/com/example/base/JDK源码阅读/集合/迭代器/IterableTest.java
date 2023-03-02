package com.example.base.JDK源码阅读.集合.迭代器;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author jiwei.xue
 * @date 2020/12/28 17:21
 */
public class IterableTest implements Iterable{
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
