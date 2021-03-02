package com.megetood.solution.interview.dynamic;

import com.megetood.structure.Array;
import com.megetood.util.TimeCounter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/17 13:06
 */
public class Fib {
    int num;

    // O(2^n)
    public int fib(int n) {
        num++;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }


    static Integer[] memo;
    // 记忆化搜索 O(2n-1)
    public int fib2(int n) {
        num++;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (memo[n] == null) {
            memo[n] = fib2(n - 1) + fib2(n - 2);
        }

        return memo[n];
    }

    // 自下向上：O(n)
    public int fib3(int n) {
        num++;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
//        int n = 60;
//        TimeCounter timer = new TimeCounter();
//        timer.start();
//        Fib fib = new Fib();
//        int res = fib.fib(n);
//        System.out.println(res);
//        timer.end();
//        timer.between().print("fib");
//        System.out.println("times: " + fib.num);
        int n = 100;
        memo = new Integer[n + 1];
        TimeCounter timer = new TimeCounter();
        timer.start();

        Fib fib = new Fib();
        fib.num = 0;
        int res = fib.fib3(n);
        System.out.println(res);
        System.out.println("times: " + fib.num);

        timer.end();
        timer.between().print("fib");

    }

}
