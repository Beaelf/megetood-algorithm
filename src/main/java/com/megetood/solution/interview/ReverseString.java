package com.megetood.solution.interview;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/17 19:14
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if(s==null||s.length<=1){
            return;
        }
        int l = 0;
        int r = s.length-1;
        while (l <= r) {
            swap(s,l,r);
            l++;
            r--;
        }
    }

    private void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
