package com.example.base.数据结构和算法.书籍.数组.面向过程数组编写;

/**
 * @author jiwei.xue
 * @date 2020/12/21 15:28
 * 面向过程的编程方式，目的是为和面向对象的编程方式作比较
 * 面向对象其实就是
 */
public class ArrayApp {

    public static void main(String[] args) {

        long[] arr;
        arr = new long[100];
        int nElems = 0;

        int j;
        long searchKey;

        // 往数组中添加元素
        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;

        nElems = 10;

        // 循环遍历输出数组中的元素
        for (j = 0; j < nElems; j++) {
            System.out.println(arr[j] + " ");
        }
        System.out.println("");

        // 查找searchKey
        searchKey = 66;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searchKey) {
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
            if (arr[j] == searchKey) {
                break;
            }
        }
        // 删除数组元素 将后一个值赋值给前一个值
        for (int k = j; k < nElems; k++) {
            arr[k] = arr[k + 1];
        }
        nElems--;

        for (j = 0; j < nElems; j++) {
            System.out.println(arr[j] + " ");
        }
        System.out.println("");

    }
}
