package com.example.base.基础.equalsandhashcode;

public class HashUtil {

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
