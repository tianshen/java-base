package com.example.base.设计模式.组合模式;

/**
 * 公司抽象类
 */
public abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    // 增加
    public abstract void add(Company company);

    // 删除
    public abstract void remove(Company company);

    // 显示
    public abstract void display(int depth);

    // 履行职责
    public abstract void lineOfDuty();
}