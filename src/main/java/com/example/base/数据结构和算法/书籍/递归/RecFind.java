package com.example.base.数据结构和算法.书籍.递归;

/**
 * @author jiwei.xue
 * @date 2020/12/22 14:07
 * 递归二分查找
 */
public class RecFind {

    private static long[] arr = new long[]{4, 23, 67, 81, 97, 100, 150};

    public static void main(String[] args) {
        long searchkey = 23L;
        int recFind = recFind(searchkey, 0, arr.length - 1);
        System.out.println(recFind);
    }

    /**
     * 使用递归二分查找
     *
     * @param searchKey
     * @param lowerBound
     * @param upperBound
     * @return
     */
    private static int recFind(long searchKey, int lowerBound, int upperBound) {

        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        if (arr[curIn] == searchKey) {
            return curIn;
        } else {
            if (lowerBound > upperBound) {
                return arr.length;
            } else {
                if (searchKey > arr[curIn]) {
                    return recFind(searchKey, curIn + 1, upperBound);
                } else {
                    return recFind(searchKey, lowerBound, upperBound - 1);
                }
            }
        }
    }
}
