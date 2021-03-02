package com.megetood.solution.interview.dynamic;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/29 14:18
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] memo = new boolean[n][n];
        String res = null;
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    memo[i][j] = true;
                } else if (l == 1) {
                    memo[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    memo[i][j] = (s.charAt(i) == s.charAt(j) && memo[i + 1][j - 1]);
                }
                if (memo[i][j] && l + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("");
    }
}
