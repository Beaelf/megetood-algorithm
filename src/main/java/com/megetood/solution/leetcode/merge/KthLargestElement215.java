package com.megetood.solution.leetcode.merge;

import java.util.PriorityQueue;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/10/10 14:13
 */
public class KthLargestElement215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        int res = -1;
        for (int i = 0; i < k; i++) {
            res = queue.remove();
            System.out.println(res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        new KthLargestElement215().findKthLargest(nums, 2);
    }
}
