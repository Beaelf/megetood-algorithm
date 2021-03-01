package com.megetood.solution.leetcode.slidewindow;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/10/10 14:33
 */
public class LongestSubStrWithoutRepeat3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 1;

        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        while (l < s.length() || r + 1 < s.length()) {
            if (freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }

            res = Math.max(res,r-l+1);
        }

        return res;
    }
}
