package com.megetood.solution.interview.dynamic;

/**
 * Minimum path sum
 *
 * @author Lei Chengdong
 * @date 2020/11/27
 */
public class MinPathSum {

    /**
     * m*n grid,
     * only move either down or right,
     * find a path from top left to bottom right,
     * minimze the sum of all numbers along this path
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];

        // 计算第一行
        f[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }

        // 计算剩下行
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + grid[i][j];
            }
        }

        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        int i = new MinPathSum().minPathSum(input);
        System.out.println(i);
    }
}
