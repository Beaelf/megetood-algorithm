package com.megetood.executor.sort;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/27 21:12
 */
public class QuickSort {

    public static void sort(int[] arr, int n) {
        quickSort(arr, 0, n - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,4,2,8,6,0};
        sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
