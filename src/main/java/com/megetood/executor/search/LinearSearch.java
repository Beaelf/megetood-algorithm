package com.megetood.executor.search;

import com.megetood.executor.ArrayGenerator;

/**
 * 线性查找
 * 使用泛型，参数类型只能使用类对象（基本数据类型使用其包装类）
 *
 * @author chengdong.lei@hand-china.com 2020/08/21 13:13
 */
public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        // 循环不变量：data[0..i-1]
        for (int i = 0; i < data.length; i++) {
            // 循环体：维持循环不变量
            if (target.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            // 纳秒时间戳
            long start = System.nanoTime();
            for (int k = 0; k < 1000; k++) {
                LinearSearch.search(data, n);
            }
            long end = System.nanoTime();
            double time = (end - start) / 1000000000.0;
            System.out.println(time + "s：");
        }

//        Student[] students = {new Student("tom"),
//                new Student("jock"),
//                new Student("judy"),
//                new Student("东东")};
//        int tom = LinearSearch.search(students, new Student("东东"));
 //        System.out.println(tom);
    }

}
