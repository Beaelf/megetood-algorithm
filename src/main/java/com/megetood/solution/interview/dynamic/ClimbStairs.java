package com.megetood.solution.interview.dynamic;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/24 15:02
 */
public class ClimbStairs {

    private int calcWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
//        if (n == 2) {
//            return 2;
//        }
        return calcWays(n - 1) + calcWays(n - 2);
    }

    Integer[] memo;

    public int calcWays2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        if (memo[n] == null) {
            memo[n] = calcWays2(n - 1) + calcWays2(n - 2);
        }

        return memo[n];
    }

    public int calcWays3(int n){
        Integer[] memo = new Integer[n + 1];
        memo[0]=1;
        memo[1]=1;
        for (int i = 2; i <= n; i++) {
            memo[i]=memo[i-1]+memo[i-2];
        }
        return memo[n];
    }

    public int climbStairs(int n) {

        return calcWays3(n);
    }


}
