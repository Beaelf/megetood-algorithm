package com.megetood.solution.interview;

import java.util.HashMap;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/12 13:13
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    Integer dis = dis(points[i], points[j]);
                    if (map.get(dis) == null) {
                        map.put(dis, 1);
                    } else {
                        map.put(dis, map.get(dis) + 1);
                    }
                }
            }

            for (Integer key : map.keySet()) {
                if (map.get(key) >= 2) {
                    res += map.get(key) * (map.get(key) - 1);
                }
            }
        }
        return res;
    }

    private Integer dis(int[] x, int[] y) {
        return (x[0] - y[0]) * (x[0] - y[0])
                + (x[1] - y[1]) * (x[1] - y[1]);
    }
}
