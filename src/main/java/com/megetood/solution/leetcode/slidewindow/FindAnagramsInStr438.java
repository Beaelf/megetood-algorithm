package com.megetood.solution.leetcode.slidewindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/10/10 14:53
 */
public class FindAnagramsInStr438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }

        int[] sArr = new int[26];
        int[] pArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = p.length() - 1;
        while (r < s.length()) {
            if (isSame(sArr, pArr)) {
                res.add(l);
            }

            if (r + 1 == s.length()) {
                break;
            }

            sArr[s.charAt(l++) - 'a']--;
            sArr[s.charAt(++r) - 'a']++;
        }
        return res;
    }

    private boolean isSame(int[] sArr, int[] pArr) {
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != pArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> res = new FindAnagramsInStr438()
                .findAnagrams("abab", "ab");
        System.out.println(res.toString());
    }
}
