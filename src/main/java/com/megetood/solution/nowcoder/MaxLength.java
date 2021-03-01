package com.megetood.solution.nowcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复字串
 *
 * @author Lei Chengdong
 * @date 2020/12/7
 */
public class MaxLength {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        if (arr == null) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int r = -1;
        int max = r - l;
        while (r + 1 < arr.length) {

            r++;

            // 重复
            if (map.containsKey(arr[r])) {
                Integer index = map.get(arr[r]);
                while (l <= index) {
                    map.remove(arr[l]);
                    l++;
                }
            }

            map.put(arr[r], r);

            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 3, 4, 5};
        int res = new MaxLength().maxLength(input);
        System.out.println(res);
    }
}
