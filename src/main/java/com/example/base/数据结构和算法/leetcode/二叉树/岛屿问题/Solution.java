package com.example.base.数据结构和算法.leetcode.二叉树.岛屿问题;

import java.util.LinkedList;

/**
 * @author xue
 * @date 2023/4/10 19:22
 */
public class Solution {

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 岛屿问题  也是用到了层序遍历的方法
     *
     * @param grid
     * @param i
     * @param j
     */
    public static void bfs(char[][] grid, int i, int j) {
        // 几行
        int m = grid.length;
        // 每行的元素个数
        int n = grid[0].length;

        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grid[i][j] = '0';
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if (x + 1 < m && grid[x + 1][y] == '1') {
                    q.offer(new int[]{x + 1, y});
                    grid[x + 1][y] = '0';
                }
                if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                    q.offer(new int[]{x - 1, y});
                    grid[x - 1][y] = '0';
                }
                if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                    q.offer(new int[]{x, y - 1});
                    grid[x][y - 1] = '0';
                }
                if (y + 1 < n && grid[x][y + 1] == '1') {
                    q.offer(new int[]{x, y + 1});
                    grid[x][y + 1] = '0';
                }
            }
        }
    }
}
