package com.example.base.JDK.集合.迭代器;

import java.util.BitSet;

public class BitSetTest {
    public static void main(String[] args) {

        BitSet bitSet = new BitSet(100000000);
        bitSet.set(12);
        boolean b = bitSet.get(13);
        System.out.println(b);

    }
}
