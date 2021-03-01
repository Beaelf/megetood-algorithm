package com.megetood.solution.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/12 12:55
 */
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                Integer key = C[i] + D[j];
                if (map.get(key) == null) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.get(0 - A[i] - B[j]) != null) {
                    res += map.get(0 - A[i] - B[j]);
                }
            }
        }
        return res;
    }
}
