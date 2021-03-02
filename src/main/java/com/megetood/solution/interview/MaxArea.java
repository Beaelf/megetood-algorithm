package com.megetood.solution.interview;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/17 19:56
 */
public class MaxArea {
    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i <= j) {
            int cur = Math.min(height[i], height[j]) * (j - i);
            if (cur > res) {
                res = cur;
            }

            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
