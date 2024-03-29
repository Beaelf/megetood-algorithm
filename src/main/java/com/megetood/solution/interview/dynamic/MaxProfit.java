package com.megetood.solution.interview.dynamic;

/**
 * find maximum profit
 *
 * @author Lei Chengdong
 * @date 2020/12/5
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;

        int[][] f = new int[n][3];

        f[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }

        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
