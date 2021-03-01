package com.megetood.solution.interview;

import com.megetood.util.Util;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/17 18:25
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l + 1 <= r) {
            char cL = s.charAt(l);
            if (!isLetter(cL) && !isNum(cL)) {
                l++;
                continue;
            }
            char cR = s.charAt(r);
            if (!isLetter(cR) && !isNum(cR)) {
                r--;
                continue;
            }
            if (Character.toLowerCase(cL) != Character.toLowerCase(cR)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    boolean isLetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    boolean isNum(char c) {
        return c >= 48 && c <= 57;
    }

    public static void main(String[] args) {
//        System.out.println('a' - 0);
//        System.out.println('z' - 0);
//        System.out.println('A' - 0);
//        System.out.println('Z' - 0);
        boolean res = new ValidPalindrome().isPalindrome("0P");
        System.out.println('0'-0);
        System.out.println('9'-0);
        System.out.println(res);
    }
}
