package com.megetood.executor;

import java.util.Random;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/21 22:03
 */
public class ArrayGenerator {

    private ArrayGenerator(){}

    public static Integer[] generateOrderedArray(int n){
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // 生成长度为n的随机数组，每个数字范围为[0,bound)
    public static Integer[] generateRandomArray(int n,int bound){
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for(int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }

}
