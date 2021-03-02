package com.megetood.solution.leetcode.set_map;

import java.util.HashSet;

/**
 * @author Lei Chengdong
 * @date 2020/10/17
 */
public class HappyNum202 {
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int a = n % 10;
            n = n / 10;
            sum = sum + a * a;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}
