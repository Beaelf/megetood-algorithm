package com.megetood.solution.interview.dynamic;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/10/09 14:31
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // memo[i]表示以nums[i]结尾的最长上升子序列长度
        int[] memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 1;
        }

        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                    if (memo[i] > res) {
                        res = memo[i];
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = new LengthOfLIS().lengthOfLIS(nums);
        System.out.println(res);
    }
}
