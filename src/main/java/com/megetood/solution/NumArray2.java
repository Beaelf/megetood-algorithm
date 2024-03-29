package com.megetood.solution;

import com.megetood.structure.SegmentTree;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/04 17:02
 */
public class NumArray2 {
    private int[] sum;// sum[i]存储前i个元素和，sum[0]=0;

    private int[] data;

    public NumArray2(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        data[index] = val;
        for (int i = index; i < sum.length; i++) {
            sum[i] = sum[i-1]-data[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
