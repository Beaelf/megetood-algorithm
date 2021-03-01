package com.megetood.solution;

import com.megetood.structure.Array;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/02 13:43
 */
public class Main {

    public static void main(String[] args) {
    }

    private static void testKFrequent() {
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        int[] res = new Solution().topKFrequent(arr, 2);
        System.out.println(Arrays.toString(res));
    }


    private static void testRomanToInt() {
        int iv = new Solution().romanToInt("IV");
        System.out.println(iv);
    }

    private static void testPalindrome() {
        boolean palindrome = new Solution().isPalindrome(1534351);
        System.out.println(palindrome);
    }

    private static void testReverse() {
        int reverse = new Solution().reverse(1534236469);
        System.out.println(reverse);
        System.out.println(Integer.MAX_VALUE);
    }
}
