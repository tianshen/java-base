package com.example.base.数据结构和算法.书籍.哈希表;

/**
 * @author jiwei.xue
 * @date 2021/1/5 16:56
 * <p>
 * 再hash法
 */
public class HashDouble {

    private DataItem[] hashArray;

    private int arraySize;

    private DataItem nonItem;

    public HashDouble(int size) {
        this.arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.println(hashArray[j].getKey() + " ");
            } else {
                System.out.println("** ");
            }
        }
        System.out.println("");
    }

    public int hashFunc01(int key) {
        return key % arraySize;
    }

    public int hashFunc02(int key) {
        return 5 - key % 5;
    }

    /**
     * 插入key
     *
     * @param item
     */
    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc01(key);
        int stepSize = hashFunc02(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;

        }
        hashArray[hashVal] = item;
    }

    /**
     * 删除key
     *
     * @param key
     * @return
     */
    public DataItem delete(int key) {
        int hashVal = hashFunc01(key);
        int stepSize = hashFunc02(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    /**
     * 查找元素
     *
     * @param key
     * @return
     */
    public DataItem find(int key) {
        int hashVal = hashFunc01(key);
        int stepSize = hashFunc02(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
