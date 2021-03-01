package com.megetood.solution.interview.dynamic;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/24 15:26
 */
public class IntegerBreak {


    Integer[] memo;

    /*
        j
        res
        m[i] = max(m[i],j*i-j,j*memo[i-j])
     */
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int integerBreak(int n) {
        memo = new Integer[n + 1];
        return breakInteger(n);
    }


    public int integerBreak2(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int i = new IntegerBreak().integerBreak2(2);
    }
}
