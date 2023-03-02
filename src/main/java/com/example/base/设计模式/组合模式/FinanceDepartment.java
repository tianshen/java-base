package com.example.base.设计模式.组合模式;

/**
 * 财务部
 */
public class FinanceDepartment extends Company {


    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Company company) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void display(int depth) {


        // 显示其枝节点名称，并对其下级进行遍历
        System.out.println(MyStringUtil.repeatString("=", depth) + name);
    }


    @Override
    public void lineOfDuty() {
        System.out.println("【" + name + "】公司财务收支管理");
    }
}