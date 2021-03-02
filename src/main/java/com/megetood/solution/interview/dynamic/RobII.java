package com.megetood.solution.interview.dynamic;

/**
 * 打家劫舍 II
 *
 * @author Lei Chengdong
 * @date 2020/12/2
 */
public class RobII {
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int begin, int end) {
        int n = end - begin + 1;
        int[] f = new int[n];

        f[n - 1] = nums[n - 1 + begin];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                f[i] = Math.max(f[i], nums[j + begin] + (j + 2 < n ? f[j + 2] : 0));
            }
        }

        return f[0];
    }

    /*
        0 1 2       0,2  n=3  f2 = n2
     */
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};
        int res = new RobII().rob(input, 0, 3);
        System.out.println(res);
    }


}
