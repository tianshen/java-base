package com.example.base;

public enum QuitGameTypeEnum {

    /**
     * 自己退出
     */
    SELF_QUIT_GAME(1),
    /**
     * 被踢退出
     */
    KICK_QUIT_GAME(2),
    /**
     * 心跳退出
     */
    HEART_QUIT_GAME(3);


    private Integer type;

    QuitGameTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
