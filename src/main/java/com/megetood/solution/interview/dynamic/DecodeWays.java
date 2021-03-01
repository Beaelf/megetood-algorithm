package com.megetood.solution.interview.dynamic;

/**
 * @author Lei Chengdong
 * @date 2020/11/29
 */
public class DecodeWays {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] f = new int[arr.length + 1];

        f[0] = 1;
        f[1] = arr[0] == '0' ? 0 : 1;
        if (s.length() <= 1) {
            return f[1];
        }

        for (int i = 2; i <= arr.length; i++) {
            int n = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');

            if (arr[i - 1] == '0' && arr[i - 2] == '0') {
                return 0;
            } else if (arr[i - 2] == '0') {
                f[i] = f[i - 1];
            } else if (arr[i - 1] == '0') {
                if (n > 26) {
                    return 0;
                }
                f[i] = f[i - 2];
            } else if (n > 26) {
                f[i] = f[i - 1];
            } else {
                f[i] = f[i - 1] + f[i - 2];
            }
        }

        return f[s.length() - 1];
    }

    public static void main(String[] args) {
        int res = new DecodeWays().numDecodings("1230");
    }
}
