package com.megetood.solution.nowcoder;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * @author Lei Chengdong
 * @date 2020/12/10
 */
public class Merge {
    public void merge(int A[], int m, int B[], int n) {
        if(B==null||B.length==0){
            return;
        }
        int[] oldA = new int[m];
        System.arraycopy(A, 0, oldA, 0, m);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {
            if (i >= m && j < n) {
                A[k++] = B[j++];
            } else if (i < m && j >= n) {
                A[k++] = oldA[i++];
            } else if (oldA[i] <= B[j]) {
                A[k++] = oldA[i++];
            } else {
                A[k++] = B[j++];
            }
        }

        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 8, 0, 0, 0, 0, 0};
        int[] B = {0, 3, 9};
        new Merge().merge(A, 1, B, 1);
    }
}
