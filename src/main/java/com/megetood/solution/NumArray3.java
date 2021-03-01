package com.megetood.solution;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/04 17:02
 */
public class NumArray3 {
    private int[] sum;// sum[i]存储前i个元素和，sum[0]=0;
    public NumArray3(int[] nums) {
        sum = new int[nums.length+1];
        sum[0]=0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}
