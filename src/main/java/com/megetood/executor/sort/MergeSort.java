package com.megetood.executor.sort;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/27 13:32
 */
public class MergeSort {
    private MergeSort() {
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }

    // 将arr[l..r]进行排序
    private static <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r) {
//        T[] aux = (T[])new Object[r-l+1];
//        for (int i = l; i <=r; i++) {
//            aux[i-l] = arr[i];
//        }
        T[] aux = Arrays.copyOfRange(arr, l, r + 1);

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {2,45, 5, 4,999,90,65,78, 1};
        mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
