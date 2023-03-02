package com.example.base.设计模式.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体公司类，树枝节点
 */
public class ConcreteCompany extends Company {
    // 用来存储其下厨枝节点和叶节点
    private List<Company> children = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        children.add(company);
    }

    @Override
    public void remove(Company company) {
        children.remove(company);
    }

    @Override
    public void display(int depth) {
        // 显示其枝节点名称，并对其下级进行遍历
        System.out.println(MyStringUtil.repeatString("=", depth) + name);
        for (Company c : children) {
            c.display(depth + 4);
        }
    }

    @Override
    public void lineOfDuty() {
        // 遍历每一个孩子的节点
        for (Company c : children) {
            c.lineOfDuty();
        }
    }
}