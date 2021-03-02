package com.megetood.solution.nowcoder;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)O(1)
 *
 * @author Lei Chengdong
 * @date 2021/1/4
 */
public class MaxsumOfSubarray {

    /**
     * 返回子数组的最大累加和
     *
     * @param arr 给定的数组
     * @return
     */
    public int maxsumofSubarray(int[] arr) {
        // write code here
        int max = -1;

        if (arr == null || arr.length == 0) {
            return max;
        }
        if (arr.length == 0) {
            return arr[0];
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1] + arr[i]);
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}
