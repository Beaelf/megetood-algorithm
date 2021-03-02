package com.megetood.executor.search;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/27 12:24
 */
public class BinarySearch {
    private BinarySearch() {
    }

//    public static  <T extends Comparable<T>> int binarySearch(T[] arr, int n, T target) {
//        int l = 0;
//        int r = n - 1;
//        while (l <= r) {
//            // 不使用(l+r)/2 防止r+l 超出Integer最大值
//            int mid = l + (r - l) / 2;
//            if (arr[mid].equals(target)) {
//                return mid;
//            }
//
//            if (target.compareTo(arr[mid]) < 0) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return -1;
//    }

    public static <T extends Comparable<T>> int binarySearch(T[] arr, int n, T target) {
        return binarySearch(arr, 0, n - 1, target);
    }

    private static <T extends Comparable<T>> int binarySearch(T[] arr, int l, int r, T target) {
        if(l>r){
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid].equals(target)) {
            return mid;
        }
        if (target.compareTo(arr[mid]) < 0) {
            return binarySearch(arr, l, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, r, target);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        System.out.println(binarySearch(arr, 3, 5));
    }
}
