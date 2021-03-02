package com.megetood.solution.interview.dynamic;

/**
 * @author Lei Chengdong
 * @date 2020/11/30
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] f = new int[m][n];

        f[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                f[0][i] = f[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                f[i][0] = f[i - 1][0];
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    f[i][j] = f[i][j - 1] + f[i - 1][j];
                }
            }
        }

        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] input = {{0, 1}, {0, 0}};
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(input));
    }
}
