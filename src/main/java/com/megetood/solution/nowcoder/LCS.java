package com.megetood.solution.nowcoder;

import java.util.Arrays;

public class LCS {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        // write code here
        int m = str1.length();
        int n = str2.length();

        // dp[i][j] str1前i个字符和str2前j个字符（以其为尾字符）的最长公共子串长度
        int[][] dp = new int[m + 1][n + 1];

        int maxlen = 0, end = 0;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] > maxlen) {
                    maxlen = dp[i][j];
                    end = j - 1;
                }
            }
        }

        if (maxlen == 0) {
            return "-1";
        }

        return str2.substring(end - maxlen + 1, end+1);
    }

    public static void main(String[] args) {
        System.out.println("12345EF".substring(1,5));
        System.out.println(new LCS().LCS("1AB2345CD","12345EF"));
    }
}
