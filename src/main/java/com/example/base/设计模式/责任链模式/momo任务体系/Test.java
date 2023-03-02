package com.example.base.设计模式.责任链模式.momo任务体系;

import com.google.common.collect.Maps;

import java.util.Map;

public class Test {

    public static void main(String[] args) {

        JoinTaskTypeInfo info = processGoBack("test01");
        if (info == null) {
            System.out.println("未查到");
        } else {
            System.out.println(info.toString());
        }
    }

    private static JoinTaskTypeInfo processGoBack(String taskType) {

        Map<String, JoinTaskTypeInfo> joinTaskTypeInfoMap = Maps.newHashMap();
        JoinTaskTypeInfo joinTaskTypeInfo01 = new JoinTaskTypeInfo();
        joinTaskTypeInfo01.setTopic("test");
        joinTaskTypeInfo01.setServiceUrl("test01");
        joinTaskTypeInfo01.setMethodName("test01");
        joinTaskTypeInfo01.setNextTaskType("test02");
        joinTaskTypeInfo01.setNextDelayTime(10);
        NextTaskGoBackCondition condition01 = new NextTaskGoBackCondition();
        condition01.setCheckOwner(0);
        condition01.setCheckSpam(0);
        condition01.setCheckRoomExist(0);
        condition01.setCheckUserExist(0);
        joinTaskTypeInfo01.setCondition(condition01);
        joinTaskTypeInfoMap.put("test01", joinTaskTypeInfo01);

        JoinTaskTypeInfo joinTaskTypeInfo02 = new JoinTaskTypeInfo();
        joinTaskTypeInfo02.setTopic("test");
        joinTaskTypeInfo02.setServiceUrl("test02");
        joinTaskTypeInfo02.setMethodName("test02");
        joinTaskTypeInfo02.setNextTaskType("test03");
        joinTaskTypeInfo02.setNextDelayTime(10);
        NextTaskGoBackCondition condition02 = new NextTaskGoBackCondition();
        condition02.setCheckOwner(1);
        condition02.setCheckSpam(1);
        condition02.setCheckRoomExist(1);
        condition02.setCheckUserExist(1);
        joinTaskTypeInfo02.setCondition(condition02);
        joinTaskTypeInfoMap.put("test02", joinTaskTypeInfo02);

        JoinTaskTypeInfo joinTaskTypeInfo03 = new JoinTaskTypeInfo();
        joinTaskTypeInfo03.setTopic("test");
        joinTaskTypeInfo03.setServiceUrl("test03");
        joinTaskTypeInfo03.setMethodName("test03");
        joinTaskTypeInfo03.setNextTaskType("");
        joinTaskTypeInfo03.setNextDelayTime(0);
        NextTaskGoBackCondition condition03 = new NextTaskGoBackCondition();
        condition03.setCheckOwner(0);
        condition03.setCheckSpam(0);
        condition03.setCheckRoomExist(0);
        condition03.setCheckUserExist(0);
        joinTaskTypeInfo03.setCondition(condition03);
        joinTaskTypeInfoMap.put("test03", joinTaskTypeInfo03);


        JoinTaskTypeInfo curTaskInfo = joinTaskTypeInfoMap.get(taskType);
        String nextTaskType = curTaskInfo.getNextTaskType();
        long nextDelayTime = curTaskInfo.getNextDelayTime();
        NextTaskGoBackCondition condition = curTaskInfo.getCondition();

        return queryNextTaskTypeExist(condition, joinTaskTypeInfoMap, nextTaskType, nextDelayTime);

    }

    private static JoinTaskTypeInfo queryNextTaskTypeExist(NextTaskGoBackCondition condition, Map<String, JoinTaskTypeInfo> joinTaskTypeInfoMap, String nextTaskType, long nextDelayTime) {
        if (!check(condition)) {
            JoinTaskTypeInfo curTaskInfo = joinTaskTypeInfoMap.get(nextTaskType);
            if (curTaskInfo == null) {
                return null;
            }
            nextTaskType = curTaskInfo.getNextTaskType();
            nextDelayTime = curTaskInfo.getNextDelayTime() + nextDelayTime;
            condition = curTaskInfo.getCondition();
            return queryNextTaskTypeExist(condition, joinTaskTypeInfoMap, nextTaskType, nextDelayTime);
        }
        JoinTaskTypeInfo joinTaskTypeInfo = joinTaskTypeInfoMap.get(nextTaskType);
        if (joinTaskTypeInfo == null) {
            return null;
        }
        joinTaskTypeInfo.setNextDelayTime(nextDelayTime);
        return joinTaskTypeInfo;
    }

    private static boolean check(NextTaskGoBackCondition condition) {
        if (condition.getCheckOwner() == 1 && condition.getCheckSpam() == 1 && condition.getCheckRoomExist() == 1 && condition.getCheckUserExist() == 1) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
