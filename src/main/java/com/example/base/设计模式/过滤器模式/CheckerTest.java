package com.example.base.设计模式.过滤器模式;

import com.google.common.collect.Lists;

import java.util.List;

public class CheckerTest {

    public static void main(String[] args) {
        List<Checker> checkerList = Lists.newArrayList();
        checkerList.add(new OwnerChecker());
        checkerList.add(new RoomExistChecker());
        if (checkerList.isEmpty()) {
            return;
        }
        CheckParam checkParam = new CheckParam();
        boolean pass = Boolean.TRUE;
        for (Checker checker : checkerList) {
            boolean checkResult = checker.doCheck(checkParam);
            if (!checkResult) {
                pass = Boolean.FALSE;
                return;
            }
        }
    }
}
