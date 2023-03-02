package com.example.base.JDK.集合.迭代器;

/**
 * Created by zhengpeng on 2017/12/22.
 */
public enum ChatRoomOperationType {
    /**
     * 进入房间
     */
    ENTER,
    /**
     * 离开房间
     */
    EXIT,
    ADD,
    DELETE,

    /**
     * 进入房间50s
     */
    FIFTY_SECONDS,

    /**
     * 35秒
     */
    HALF_MINUTE,

    /**
     * 进入房间两分钟
     */
    ONE_MINUTE,

    /**
     * 进入房间两分钟
     */
    TWO_MINUTE,

    /**
     * 进入房间三分钟
     */
    THREE_MINUTE,

    /**
     * 进入房间5分钟
     */
    FIVE_MINUTE,

    /**
     * 进入房间10分钟，可重复触发
     */
    TEN_MINUTE_REPEAT,

    /**
     * 麦上三分钟
     */
    Three_MINUTE_ON_MIC,

    /**
     * 上麦10分钟，可重复触发
     */
    TEN_MINUTE_ON_MIC_REPEAT,

    /**
     * 房间改成私密
     */
    ROOM_PRIVACY,

    /**
     * 专属房间升级
     */
    SUPER_ROOL_LEVEL_UP,

    /**
     * 进入房间1分钟，可重复触发
     */
    ONE_MINUTE_REPEAT,

    /**
     * 进入房间两分钟，可重复触发
     */
    TWO_MINUTE_REPEAT,

    /**
     * 加入房间30s，可重复触发
     */
    THIRTY_SECONDS_REPEAT;
}
