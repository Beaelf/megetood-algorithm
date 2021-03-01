package com.megetood.solution.interview;

import com.megetood.solution.Solution;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/10 12:11
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j++;
            } else {
                if (i > 0 && nums[i] != 0 && nums[i - 1] == 0) {
                    nums[i - j] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        System.out.println(j);
    }

    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(j);
    }

    public void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                if(i!=j){
                    int temp = nums[j];
                    nums[j++] = nums[i];
                    nums[i] = temp;
                }else{
                    j++;
                }
            }
        }
        System.out.println(j);
    }



    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(arr));
        new MoveZeroes().moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));

    }
}
