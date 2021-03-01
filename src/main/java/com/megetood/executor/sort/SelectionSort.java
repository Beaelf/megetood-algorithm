package com.megetood.executor.sort;

import com.megetood.executor.ArrayGenerator;

/**
 * 选择排序 稳定的O(n^2)
 *
 * @author chengdong.lei@hand-china.com 2020/08/22 18:36
 */
public class SelectionSort {

    private SelectionSort() {
    }


    public static <E extends Comparable<E>> void sort2(E[] arr) {

        // arr[0..i)是有序的，arr[i..n)无序的
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i..n)中最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            SortingHelper.swap(arr, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        // arr[0..i)是有序的，arr[i..n)无序的
        for (int i = arr.length - 1; i >= 0; i--) {
            // 选择 arr[i..n)中最小值的索引
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            SortingHelper.swap(arr, i, maxIndex);
//            System.out.println(Arrays.toString(arr));
        }
    }


    public static void main(String[] args) throws NoSuchMethodException {
//        Integer[] arr = {10, 6, 9, 1, 0, 4};
//        SelectionSort.sort(arr);
//        for (int e : arr) {
//            System.out.print(e + " ");
//        }
//        System.out.println();
//
//        Student[] students = {
//                new Student("tom", 98),
//                new Student("to", 27),
//                new Student("tm", 54)
//        };
//        SelectionSort.sort(students);
//        for (Student student : students) {
//            System.out.println(student);
//        }
//
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(SelectionSort.class, arr);
        }

    }
}
