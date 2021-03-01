package com.megetood.solution.interview;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/10 18:47
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = -1;
        int[] temp = new int[m + n];
        while (i < m || j < n) {
            if (k + 1 >= temp.length) {
                return;
            }
            if (i == m) {
                temp[++k] = nums2[j++];
            } else if (j == n) {
                temp[++k] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                temp[++k] = nums1[i++];
            } else {
                temp[++k] = nums2[j++];
            }
        }

        for (int t = 0; t < m + n; t++) {
            nums1[t] = temp[t];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[1];
        int[] nums2 = {1};
        new Merge().merge(nums1,0,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
