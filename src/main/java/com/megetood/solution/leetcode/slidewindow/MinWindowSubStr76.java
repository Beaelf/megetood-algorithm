package com.megetood.solution.leetcode.slidewindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 最小覆盖字串： minimum window substring
 *
 * @author chengdong.lei@hand-china.com 2020/10/13 14:43
 */
public class MinWindowSubStr76 {

    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> sMap = new HashMap<>();

    public String minWindow(String s, String t) {
        String res = "";
        int sLen = s.length();
        if (s == null || t == null || sLen < t.length()) {
            return res;
        }

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            tMap.put(key, tMap.getOrDefault(key, 0) + 1);
        }

        int l = 0,r = -1;
        int  len = Integer.MAX_VALUE, resL = -1, resR = -1;
        while (r < sLen) {
            r++;
            if (r < sLen && tMap.containsKey(s.charAt(r))) {
                char R = s.charAt(r);
                sMap.put(R, sMap.getOrDefault(R, 0) + 1);
            }
//            if (r >= sLen) {
//                r--;
//                break;
//            }
            while (containT() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    resL = l;
                    resR = l + len;
                }
                char L = s.charAt(l);
                if (tMap.containsKey(L)) {
                    sMap.put(L, sMap.getOrDefault(L, 0) - 1);
                }
                l++;
            }
        }

        return resL == -1 ? res : s.substring(resL, resR);
    }

    private boolean containT() {
        for (Character key : tMap.keySet()) {
            if (sMap.getOrDefault(key, 0) < tMap.get(key)) {
                return false;
            }
        }
        return true;
    }


//    public boolean containT() {
//        Iterator iter = tMap.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            Character key = (Character) entry.getKey();
//            Integer val = (Integer) entry.getValue();
//            if (sMap.getOrDefault(key, 0) < val) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf" ;
        String t = "cae";
        String res = new MinWindowSubStr76().minWindow(s, t);
        System.out.println(res);
    }
}
