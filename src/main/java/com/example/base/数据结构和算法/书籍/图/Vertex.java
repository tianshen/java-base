package com.example.base.数据结构和算法.书籍.图;

/**
 * @author jiwei.xue
 * @date 2021/1/7 18:14
 */
public class Vertex {

    public char label;

    public boolean wasVisited;

    public Vertex(char lab) {
        this.label = lab;
        wasVisited = false;
    }
}
