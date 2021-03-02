package com.megetood.solution.interview.dynamic;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/27 14:40
 */
public class Knapsack01 {
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        return res;
    }

    Integer[][] memo;

    private int bestValue2(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] != null) {
            return memo[index][c];
        }

        int res = bestValue2(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, v[index] + bestValue2(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }


    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new Integer[n][c + 1];
        return bestValue(w, v, n - 1, c);
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int c = 5;
        int res = new Knapsack01().knapsack01(w, v, c);
        System.out.println(res);
    }

    public int knapsack02(int[] w, int[] v, int c) {
        int n = w.length;
        if(n==0){
            return 0;
        }
        memo = new Integer[n][c + 1];
        for (int j = 0; j <= c; j++) {
            memo[0][j] = j >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }

        return memo[n - 1][c];
    }

    public int knapsack03(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new Integer[2][c + 1];
        for (int j = 0; j <= c; j++) {
            memo[0][j] = j >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= w[i]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
                }
            }
        }

        return memo[(n - 1) % 2][c];
    }

    public int knapsack04(int[] w, int[] v, int c) {
        int n = w.length;
        Integer[] memo = new Integer[c + 1];
        for (int j = 0; j <= c; j++) {
            memo[j] = j >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = c; j >= w[i]; j--) {
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
            }
        }

        return memo[c];
    }
}
