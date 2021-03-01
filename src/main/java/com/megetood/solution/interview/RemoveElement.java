package com.megetood.solution.interview;

import java.util.Arrays;

/**
 * 删除元素
 *
 * @author chengdong.lei@hand-china.com 2020/09/10 13:09
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != k) {
                    int temp = nums[k];
                    nums[k++] = nums[i];
                    nums[i] = temp;
                } else {
                    k++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int i = new RemoveElement().removeElement(nums, 3);
        System.out.println(i);
    }
}
