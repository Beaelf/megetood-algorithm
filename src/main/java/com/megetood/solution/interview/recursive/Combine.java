package com.megetood.solution.interview.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/21 19:32
 */
public class Combine {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        generateCombinatinos(n,k,0,new ArrayList<>());
        return res;
    }

    private void generateCombinatinos(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n-(k-list.size())+1; i++) {
            list.add(i);
            generateCombinatinos(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }

        return;

    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Combine().combine(3, 2);
        System.out.println(res.toString());
    }
}