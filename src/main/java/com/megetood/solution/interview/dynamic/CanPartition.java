package com.megetood.solution.interview.dynamic;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/10/09 20:08
 */
public class CanPartition {


    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || index < 0) {
            return false;
        }

        return tryPartition(nums, index - 1, sum)
                || tryPartition(nums, index - 1, sum - nums[index]);

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    Integer[][] memo;

    private boolean tryPartition2(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || index < 0) {
            return false;
        }

        if (memo[index][sum] != null) {
            return memo[index][sum] == 1;
        }

        memo[index][sum] = (tryPartition2(nums, index - 1, sum)
                || tryPartition2(nums, index - 1, sum - nums[index])) ? 1 : 0;

        return memo[index][sum] == 1;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        memo = new Integer[nums.length][sum / 2 + 1];
        return tryPartition2(nums, nums.length - 1, sum / 2);
    }

    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        int c = sum / 2;
        boolean[] memo = new boolean[c + 1];

        for (int i = 0; i <= c; i++) {
            memo[i] = nums[0] == i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = c;j>=nums[i] ;j--) {
                memo[j] = memo[j]||memo[j-nums[i]];
            }
        }

        return memo[c];
    }
}
