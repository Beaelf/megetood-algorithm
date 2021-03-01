package com.megetood.solution.interview;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/17 19:25
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] arr = s.toCharArray();

        int l = 0;
        int r = arr.length-1;
        while (l + 1 <= r) {
            char L = arr[l];
            if (!isVowel(L)) {
                l++;
                continue;
            }
            char R = arr[r];
            if (!isVowel(R)) {
                r--;
                continue;
            }

            swap(arr, l, r);
            l++;
            r--;
        }

        return String.valueOf(arr);
    }

    private void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                ||c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        String hello = new ReverseVowels().reverseVowels("hello");
        System.out.println(hello);
    }

}
