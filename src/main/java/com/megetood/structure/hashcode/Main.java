package com.megetood.structure.hashcode;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/09 13:04
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, 2, "tom", "jack");
        System.out.println(student.hashCode());
        Student student2 = new Student(1,2,"tom","Jack");
        System.out.println(student2.hashCode());
    }
}
