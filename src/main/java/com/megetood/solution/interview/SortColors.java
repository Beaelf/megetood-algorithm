package com.megetood.solution.interview;

import com.megetood.util.Util;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/10 17:26
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;
        for (int t = 0; t < nums.length; t++) {
            if (nums[t] == 0) {
                i++;
            } else if (nums[t] == 1) {
                j++;
            } else {
                k++;
            }
        }
        for (int l = 0; l < nums.length; l++) {
            if (l >= 0 && l < i) {
                nums[l] = 0;
            } else if (l >= i && l < j) {
                nums[l] = 1;
            } else {
                nums[l] = 2;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int zero = -1;
        int two = nums.length;

        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            } else {
                assert (nums[i] == 0);
                zero++;
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] =temp;
                i++;
            }
        }
    }
}
