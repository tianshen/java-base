package com.example.base.数据结构和算法.leetcode.二分查找.搜索二维矩阵;

class Solution {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b = searchMatrix(matrix, 3);
        System.out.println(b);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 把二维数组映射到一维
        int left = 0, right = m * n - 1;
        // 前文讲的标准的二分搜索框架
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(get(matrix, mid) == target)
                return true;
            else if (get(matrix, mid) < target)
                left = mid + 1;
            else if (get(matrix, mid) > target)
                right = mid - 1;
        }
        return false;
    }

    // 通过一维坐标访问二维数组中的元素
    static int get(int[][] matrix, int index) {
        int m = matrix.length, n = matrix[0].length;
        // 计算二维中的横纵坐标
        int i = index / n, j = index % n;
        return matrix[i][j];
    }
}