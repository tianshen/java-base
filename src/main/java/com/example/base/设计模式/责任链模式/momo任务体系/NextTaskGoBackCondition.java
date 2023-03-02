package com.example.base.设计模式.责任链模式.momo任务体系;

import lombok.Data;

@Data
public class NextTaskGoBackCondition {

    /**
     * 是否是房主 0 不需要校验 1 是房主通过 2 不是房主通过
     */
    private int checkOwner;

    /**
     * 是否是spam用户 0 不需要校验 1 是spam通过 2 不是spam通过
     */
    private int checkSpam;

    /**
     * 用户是否存在 0 不需要校验 1 存在通过 2 不存在通过
     */
    private int checkUserExist;

    /**
     * 房间是否存在 0 不需要校验 1 存在通过 2 不存在通过
     */
    private int checkRoomExist;
}
