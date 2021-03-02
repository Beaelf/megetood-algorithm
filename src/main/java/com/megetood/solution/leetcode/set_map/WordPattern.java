package com.megetood.solution.leetcode.set_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据模板，匹配字符串
 *
 * @author Lei Chengdong
 * @date 2020/10/19
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if (sArr.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < sArr.length; i++) {
            char key = pattern.charAt(i);
            if (!map.containsKey(key)) {
                if (map.containsValue(sArr[i])) {
                    return false;
                }
                map.put(key, sArr[i]);
            } else {
                if (!map.get(key).equals(sArr[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean b = new WordPattern().wordPattern("abba", "cat cat cat cat");
        System.out.println(b);
    }
}
