package com.megetood.solution.nowcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author Lei Chengdong
 * @date 2020/12/8
 */
public class TwoSum {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int cur = target - numbers[i];
            if (map.containsKey(cur)) {
                return new int[]{map.get(cur), i};
            }
            map.put(numbers[i], i);
        }

        return null;
    }
}
