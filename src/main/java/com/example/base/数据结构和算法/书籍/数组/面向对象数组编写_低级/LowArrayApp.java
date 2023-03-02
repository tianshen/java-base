package com.example.base.数据结构和算法.书籍.数组.面向对象数组编写_低级;

/**
 * @author jiwei.xue
 * @date 2020/12/21 17:34
 */
public class LowArrayApp {

    public static void main(String[] args) {
        LowArray arr;
        arr = new LowArray(100);
        int nElems = 0;
        int j;

        arr.setElem(0, 77);
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 00);
        arr.setElem(8, 66);
        arr.setElem(9, 33);
        nElems = 10;

        for (j = 0; j < nElems; j++) {
            System.out.println(arr.getElem(j) + " ");
        }
        System.out.println("");

        // 查找searchKey
        int searchKey = 66;
        for (j = 0; j < nElems; j++) {
            if (arr.getElem(j) == searchKey) {
                break;
            }
        }
        // 判断是否找到searchKey所对应的索引
        if (j == nElems) {
            System.out.println("Cant not find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }

        // 删除 searchKey
        searchKey = 55;
        for (j = 0; j < nElems; j++) {
            if (arr.getElem(j) == searchKey) {
                break;
            }
        }
        for (int k = j; k < nElems; k++) {
            arr.setElem(k, arr.getElem(k + 1));
        }
        nElems--;

        for (j = 0; j < nElems; j++) {
            System.out.println(arr.getElem(j) + " ");
        }
        System.out.println("");
    }
}
