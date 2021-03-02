package com.megetood.solution.interview;

import java.util.Arrays;

/**
 * 找第K大的元素
 *
 * @author chengdong.lei@hand-china.com 2020/09/11 16:35
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        mergeSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    public int findKthLargest2(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[k - 1];
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        if (nums[mid] < nums[mid + 1]) {
            merge(nums, l, mid, r);
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];

        int i = l;
        int j = mid + 1;
        for (int k = 0; k < aux.length; k++) {
            if (i > mid) {
                aux[k] = nums[j++];
            } else if (j > r) {
                aux[k] = nums[i++];
            } else if (nums[i] >= nums[j]) {
                aux[k] = nums[i++];
            } else {
                aux[k] = nums[j++];
            }
        }
        for (int k = 0; k < aux.length; k++) {
            nums[k + l] = aux[k];
        }

    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort(nums, l, p);
        quickSort(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > v) {
                swap(nums, i, ++j);
            }
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = new FindKthLargest().findKthLargest2(nums, 4);
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
    }
}
