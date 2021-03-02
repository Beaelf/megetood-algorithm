package com.megetood.solution.interview.dynamic;

import com.google.common.collect.Lists;

/**
 * rob house along a street,the adjcent house has security system
 * connected and it will contact the police if two adjcent houses
 * were broken into on the same night
 *
 * @author chengdong.lei@hand-china.com 2020/09/27 13:55
 */
public class Rob {
    public int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int res = 0;
        for (int i = index; i <= nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        return res;
    }

    Integer[] memo;

    public int tryRob2(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int res = 0;
        for (int i = index; i <= nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob2(nums, i + 2));
        }

        memo[index] = res;
        return res;
    }

    public int rob(int[] nums) {
        memo = new Integer[nums.length];
        return tryRob(nums, 0);
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        Integer[] memo = new Integer[n];

        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            memo[i]=-1;
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }

        return memo[0];
    }


}
