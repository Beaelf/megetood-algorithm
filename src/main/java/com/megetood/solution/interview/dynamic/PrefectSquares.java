package com.megetood.solution.interview.dynamic;

/**
 * find the least number of prefect square numbers
 *
 * @author Lei Chengdong
 * @date 2020/11/28
 */
public class PrefectSquares {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (isSquare(i)) {
                f[i] = 1;
                continue;
            }
            for (int j = 1; j <= i - 1; j++) {
                if (f[i] == 0) {
                    f[i] = f[i - j] + f[j];
                    continue;
                }
                f[i] = Math.min(f[i - j] + f[j], f[i]);
            }
        }
        return f[n];
    }

    public static boolean isSquare(int n) {
        double fsqrt = Math.sqrt(n);
        int m = (int) fsqrt;
        return m * m == n;
    }

    public static void main(String[] args) {
//        int res = new PrefectSquares().numSquares(12);
//        System.out.println(res);
        System.out.println(isSquare(3000));
    }

}
