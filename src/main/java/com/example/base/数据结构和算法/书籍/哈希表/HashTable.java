package com.example.base.数据结构和算法.书籍.哈希表;

/**
 * @author jiwei.xue
 * @date 2021/1/5 16:56
 */
public class HashTable {

    private DataItem[] hashArray;

    private int arraySize;

    private DataItem nonItem;

    public HashTable(int size) {
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

    public int hashFunc(int key) {
        return key % arraySize;
    }

    /**
     * 插入key
     *
     * @param item
     */
    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal++;
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
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal++;
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
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal++;
            hashVal %= arraySize;
        }
        return null;
    }
}
