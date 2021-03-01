package com.megetood.test;

import com.megetood.structure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/16 22:36
 */
public class Main {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(newArr));

        ArrayList<Object> list = new ArrayList<>();
        list.add(2);
    }
}
