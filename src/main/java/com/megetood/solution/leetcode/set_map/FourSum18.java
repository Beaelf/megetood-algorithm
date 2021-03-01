package com.megetood.solution.leetcode.set_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * four sum
 *
 * @author Lei Chengdong
 * @date 2020/11/9
 */
public class FourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();

            if (nums == null || nums.length < 4) {
                return res;
            }

            Arrays.sort(nums);

            int length = nums.length;
            for (int i = 0; i < length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }

                    int l = j + 1;
                    int r = length - 1;
                    while (l < r) {
                        int sum = nums[i] + nums[j] + nums[l] + nums[r];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            l++;
                            while (l < r && nums[r] == nums[r - 1]) {
                                l--;
                            }
                            r--;
                        } else if (sum < target) {
                            l++;
                        } else {
                            r--;
                        }

                    }
                }
            }

            return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = new FourSum18().fourSum(nums, 0);
        System.out.println(lists);
    }
}
