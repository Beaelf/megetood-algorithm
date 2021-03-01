package com.megetood.solution.interview.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/21 18:40
 */
public class Permute {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>(nums.length);
        used = new boolean[nums.length];
        generatePermutation(nums, 0, list);
        return res;
    }

    private void generatePermutation(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Permute().permute(nums);
        System.out.println(res.toString());
    }
}
