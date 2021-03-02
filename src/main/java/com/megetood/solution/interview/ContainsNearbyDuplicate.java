package com.megetood.solution.interview;

import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/12 14:08
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = l + k;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if (i <= r && map.get(nums[i]) >= 2) {
                return true;
            }
            if (i == r) {
                l++;
                r++;
                map.put(nums[l - 1], map.get(nums[l - 1]) - 1);
            }

        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }

            record.add(nums[i]);

            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }
        }
        return false;
    }

    /*
        |3-b|<=t;
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();
        long tar = t;
        for (int i = 0; i < nums.length; i++) {

            long numI = nums[i];

            if (findLowerBound(record, numI - t, numI + t) == true) {
                return true;
            }

            record.add(numI);

            if (record.size() == k + 1) {
                long rem = nums[i - k];
                record.remove(rem);
            }
        }
        return false;
    }

    private boolean findLowerBound(TreeSet<Long> set, long l, long r) {
        if (set.isEmpty()) {
            return false;
        }

        return set.ceiling(l) == null ? false : set.ceiling(l) <= r;
    }


    public static void main(String[] args) {
//        int[] nums = {1, 0, 1, 1};
//        int[] nums = {1,5,9,1,5,9};
//        int[] nums = {2147483640, 2147483641};
        int[] nums = {1, 2, 3, 1};

        int k = 3;
        int t = 0;
        boolean flag = new ContainsNearbyDuplicate().containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(flag);
    }
}
