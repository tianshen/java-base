package com.example.base.JDK.集合.迭代器;

public enum FlowCardUseState {

    CAN_NOT_BE_USED(0),
    CAN_BE_USED(1),
    NOT_HAVE(2),
    ;

    FlowCardUseState(int state) {
        this.state = state;
    }

    private int state;

    public Integer getType() {
        return state;
    }

    public void setType(Integer state) {
        this.state = state;
    }
}
