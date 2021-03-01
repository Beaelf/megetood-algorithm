package com.megetood.solution.interview.dynamic;

/**
 * @author Lei Chengdong
 * @date 2020/11/30
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 1) {
            return 1;
        }

        int[][] f = new int[m][n];

        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            f[i][0] = 1;
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }

        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int res = new UniquePaths().uniquePaths(3, 7);
        System.out.println(res);
    }
}
