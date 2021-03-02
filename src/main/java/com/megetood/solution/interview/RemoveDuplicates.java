package com.megetood.solution.interview;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/10 13:17
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[k]){
                nums[++k] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return k+1;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int i = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(i);
    }

}
