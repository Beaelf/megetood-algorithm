package com.megetood.executor.sort;

import com.megetood.executor.ArrayGenerator;

import java.util.Arrays;

/**
 * 归并，自底向上
 *
 * @author chengdong.lei@hand-china.com 2020/08/27 13:32
 */
public class MergeSortForIntegerBU {
    private MergeSortForIntegerBU() {
    }

    public static void mergeSort(Integer[] arr, Integer n) {
        for (int size = 1; size <= n; size += size) {
            for (int i = 0; i + size < n; i = size + size) {
                merge(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1));
            }
        }
    }

    private static void merge(Integer[] arr, Integer l, Integer mid, Integer r) {
        Integer[] aux = new Integer[r - l + 1];
        for (Integer i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        Integer i = l;
        Integer j = mid + 1;

        for (Integer k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

//        SortingHelper.sortTest(InsertionSort.class,arr1);
        SortingHelper.sortTest(MergeSortForIntegerBU.class, arr2);
    }
}
