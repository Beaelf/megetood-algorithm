package com.megetood.executor.sort;

import com.megetood.executor.ArrayGenerator;

import java.util.Arrays;

/**
 * 插入排序：数组有序时O(n),最坏O(n^2)
 *
 * @author chengdong.lei@hand-china.com 2020/08/22 21:35
 */
public class InsertionSort {

    private InsertionSort() {
    }

    // 交换方式
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将arr[i]插入到合适的位置
//            for (int j = i; j >0; j--) {
//                // 向前插
//                if(arr[j].compareTo(arr[j-1])>0){
//                    continue;
//                }
//                SortingHelper.swap(arr,j,j-1);
//            }
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                SortingHelper.swap(arr, j, j - 1);
            }
        }
    }

    // 赋值方式
    public static <E extends Comparable<E>> void sort1(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j > 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    // 赋值方式
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            E t = arr[i];
            int j;
            for (j = i; j > l && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    // 赋值方式
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j < arr.length - 1 && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,4,5,2,8,6,9,0};
        sort(arr,4,arr.length-1);
        System.out.println(Arrays.toString(arr));
//        int[] dataSize = {10000, 100000};
//        for (int n : dataSize) {
//            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//
//            SortingHelper.sortTest(InsertionSort.class, arr);
//            SortingHelper.sortTest("InsertionSort", arr);
//            SortingHelper.sortTest("SelectionSort",arr2);

//            Integer[] arr3 = ArrayGenerator.generateOrderedArray(n);
//            Integer[] arr4 = Arrays.copyOf(arr,arr.length);
//
//            SortingHelper.sortTest("InsertionSort", arr3);
//            SortingHelper.sortTest("SelectionSort",arr4);
//
//            System.out.println();
//        }
    }


}
