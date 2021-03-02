package com.megetood.util;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/10 18:28
 */
public class Util {
    private Util() {
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static boolean isLetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    public static boolean isNum(char c) {
        return c >= 48 && c <= 57;
    }

    public static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void main(String[] args) {
        for (char i = 'A'; i <= 'Z'; i++) {
            boolean letter = isLetter(i);
            if (letter == false) {
                System.out.println("error");
                return;
            }
        }
    }
}
