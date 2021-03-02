package com.megetood.solution.nowcoder;

/**
 * todo
 *
 * @author Lei Chengdong
 * @date 2020/11/23
 */
public class BinarySearch {
    public int upper_bound_(int n, int v, int[] a) {
        // write code here
        int res = binarySearch(0, n - 1, a, v);
        return res + 1;
    }

    private int binarySearch(int l, int r, int[] a, int v) {
        if (l >= r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (v == a[mid]) {
            return mid;
        } else if (v < a[mid]) {
            return binarySearch(l, mid, a, v);
        } else {
            return binarySearch(mid + 1, r, a, v);
        }

    }

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 4, 5};
        int res = new BinarySearch().upper_bound_(5, 4, input);
        System.out.println(res);
    }

}
