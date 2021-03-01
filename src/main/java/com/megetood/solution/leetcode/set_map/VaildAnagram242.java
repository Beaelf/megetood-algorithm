package com.megetood.solution.leetcode.set_map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有效的异构字符串
 *
 * @author chengdong.lei@hand-china.com 2020/10/15 10:54
 */
public class VaildAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            sMap.put(cur, sMap.getOrDefault(cur, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            if (!sMap.containsKey(cur)) {
                return false;
            } else {
                if (sMap.get(cur) < 1) {
                    return false;
                }
                sMap.put(cur, sMap.get(cur) - 1);
            }
        }

        return true;
    }
}
