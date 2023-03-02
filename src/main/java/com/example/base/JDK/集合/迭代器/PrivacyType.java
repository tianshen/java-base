package com.example.base.JDK.集合.迭代器;

import java.io.Serializable;


public enum PrivacyType implements Serializable {

    //1公开,2仅粉丝,3仅好友,4私密,5仅同城,6仅陌生人
    PUBLIC(1), FOLLOW(2), FRIEND(3), PRIVATE(4), SAMECITY(5), STRANGER(6);

    private int type;

    PrivacyType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }


    public static PrivacyType getPrivacyType(int type) {

        PrivacyType[] privacyTypes = PrivacyType.values();
        for (PrivacyType privacyType : privacyTypes) {
            if (privacyType.getType() == type) {
                return privacyType;
            }
        }
        return null;
    }

}
