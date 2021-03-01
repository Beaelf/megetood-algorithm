package com.megetood.solution.leetcode.set_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 异构字符串
 *
 * @author Lei Chengdong
 * @date 2020/10/20
 */
public class IsomorphicStr205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char key = s.charAt(i);
            char val = t.charAt(i);
            if (!map.containsKey(key)) {
                if (map.containsValue(val)) {
                    return false;
                }
                map.put(key, val);
            } else {
                if (map.get(key) != val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new IsomorphicStr205().isIsomorphic("abb", "add");
        System.out.println(res);
    }
}
