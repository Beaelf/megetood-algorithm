package com.megetood.solution.interview;

import com.megetood.structure.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/11 11:28
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j && numbers[i] + numbers[j] == target) {
                    if (i <= j) {
                        res[0] = i + 1;
                        res[1] = j + 1;
                    } else {
                        res[0] = j + 1;
                        res[1] = i + 1;
                    }
                }
            }
        }
        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int dest = target - numbers[i];
            int j = binarySearch(numbers, 0, numbers.length, dest);
            if (j != -1 && j != i) {
                res[0] = i <= j ? i + 1 : j + 1;
                res[1] = i <= j ? j + 1 : i + 1;
                break;
            }
        }

        return res;
    }

    private int binarySearch(int[] arr, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return binarySearch(arr, l, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, r, target);
        }
    }

    public int[] twoSum3(int[] numbers, int target) {
        int[] res = new int[2];

        int i = 0;
        int j = numbers.length - 1;
        while (i != j) {
            if (numbers[i] + numbers[j] == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return res;
    }

    public int[] twoSum4(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int cur = target - numbers[i];
            if (map.get(cur) != null) {
                System.out.println(cur);
                return new int[]{map.get(cur), i};
            }
            map.put(numbers[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 1, 7};
        int[] res = new TwoSum().twoSum4(nums, 3);
        System.out.println(Arrays.toString(res));
    }

}
