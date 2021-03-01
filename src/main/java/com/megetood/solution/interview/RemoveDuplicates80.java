package com.megetood.solution.interview;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/10 13:17
 */
public class RemoveDuplicates80 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int t = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]){
                t++;
            }else {
                t = 1;
            }
            if(t<=2){
                nums[k++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return k ;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int i = new RemoveDuplicates80().removeDuplicates(nums);
        System.out.println(i);
    }

}
