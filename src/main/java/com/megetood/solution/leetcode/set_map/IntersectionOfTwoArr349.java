package com.megetood.solution.leetcode.set_map;

import java.util.HashSet;
import java.util.Set;

/**
 * 集合交集
 *
 * @author chengdong.lei@hand-china.com 2020/10/15 10:26
 */
public class IntersectionOfTwoArr349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if(set1.contains(nums2[i])){
                set.add(nums2[i]);
            }
        }

        int[] res = new int[set.size()];
        int i = 0;
        for (Integer e : set) {
            res[i++] = e;
        }

        return res;
    }
}
