package com.megetood.executor.sort;

import com.megetood.util.TimeCounter;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/22 20:53
 */
public class SortingHelper {

    private SortingHelper() {
    }

    // 判断一个数组是否有序
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) {
        TimeCounter timeCounter = new TimeCounter();
        timeCounter.start();
        if ("SelectionSort".equals(sortname)) {
            SelectionSort.sort(arr);
        } else if ("InsertionSort".equals(sortname)) {
            InsertionSort.sort(arr);
        } else {
            throw new RuntimeException("sortname is not exist");
        }
        timeCounter.end();

        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + " failed");
        }

        System.out.println(
                String.format("%s, n = %d: %f", sortname, arr.length, timeCounter.between().getTime()));
    }


    public static <E extends Comparable<E>> void sortTest(Class<?> sortname, E[] arr) {
        TimeCounter timeCounter = new TimeCounter();
        timeCounter.start();
        if (SelectionSort.class.equals(sortname)) {
            SelectionSort.sort(arr);
        } else if (InsertionSort.class.equals(sortname)) {
            InsertionSort.sort(arr);
        } else if (MergeSortForInteger.class.equals(sortname)) {
            MergeSortForInteger.mergeSort((Integer[]) arr,arr.length);
        } else if (MergeSortForIntegerBU.class.equals(sortname)) {
            MergeSortForInteger.mergeSort((Integer[]) arr,arr.length);
        } else {
            throw new RuntimeException("sortname is not exist");
        }
        timeCounter.end();

        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + " failed");
        }

        System.out.println(
                String.format("%s, n = %d: %f", sortname.getSimpleName(), arr.length, timeCounter.between().getTime()));
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
