package com.megetood.solution.leetcode.set_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * find unique triplets
 *
 * @author Lei Chengdong
 * @date 2020/10/21
 */
public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int k = len -1;

            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                while(j<k&&nums[k]+nums[j]>target){
                    k--;
                }
                if(j==k){
                    break;
                }
                if(nums[j]+nums[k]==target){
                    List<Integer> item = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(item);
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new ThreeSum15().threeSum(new int[0]);
        System.out.println(res);
    }
}
