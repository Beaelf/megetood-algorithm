package com.megetood.executor.sort;

import com.megetood.executor.ArrayGenerator;
import org.omg.CORBA.Object;

import java.util.Arrays;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/27 13:32
 */
public class MergeSortForInteger {
    private MergeSortForInteger() {
    }

    public static void mergeSort(Integer[] arr, Integer n) {
        mergeSort(arr, 0, n - 1);
    }

    // 将arr[l..r]进行排序
    private static void mergeSort(Integer[] arr, Integer l, Integer r) {
//        if (l >= r) {
//            return;
//        }
        if(r-l<=15){
            InsertionSort.sort(arr,l,r);
            return;
        }
        Integer mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if(arr[mid]>arr[mid+1]){
            merge(arr, l, mid, r);
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
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);

//        SortingHelper.sortTest(InsertionSort.class,arr1);
        SortingHelper.sortTest(MergeSortForInteger.class,arr2);
    }
}
