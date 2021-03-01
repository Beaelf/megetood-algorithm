package com.megetood.solution.leetcode.merge;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/10/10 14:02
 */
public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        for (int i = 0; i < m; i++) {
            tmp[i] = nums1[i];
        }

        int i = 0;
        int j = 0;
        int t = 0;
        while (i < m || j < n) {
            if (i >= m) {
                nums1[t++] = nums2[j++];
            } else if (j >= n) {
                nums1[t++] = tmp[i++];
            } else if (tmp[i] <= nums2[j]) {
                nums1[t++] = tmp[i++];
            } else {
                nums1[t++] = nums2[j++];
            }
        }
    }
}
