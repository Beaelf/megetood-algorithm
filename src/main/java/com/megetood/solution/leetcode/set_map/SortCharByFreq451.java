package com.megetood.solution.leetcode.set_map;

import jdk.nashorn.internal.ir.CallNode;

import java.util.*;

/**
 * 根据频次排序字符串
 *
 * @author Lei Chengdong
 * @date 2020/10/20
 */
public class SortCharByFreq451 {
    Map<Character, Integer> map;

    public String frequencySort(String s) {
        map = new HashMap<>();
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (!map.containsKey(key)) {
                map.put(key, 1);
                chars.add(key);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }


        mergeSort(chars, 0, chars.size() - 1);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            Character cur = chars.get(i);
            for (int j = 0; j < map.get(cur); j++) {
                res.append(cur);
            }
        }

        return res.toString();
    }

    private void mergeSort(List<Character> chars, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(chars, l, mid);
        mergeSort(chars, mid + 1, r);
        merge(chars, l, mid, r);
    }

    private void merge(List<Character> chars, int l, int mid, int r) {
        Character[] temp = new Character[r - l + 1];
        for (int i = l; i <= r; i++) {
            Character aChar = chars.get(i);
            temp[i - l] = aChar;
        }

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                chars.set(k, temp[j - l]);
                j++;
            } else if (j > r) {
                chars.set(k,temp[i - l]);
                i++;
            } else if (map.get(temp[i-l]) >= map.get(temp[j-l])) {
                chars.set(k,temp[i - l]);
                i++;
            } else {
                chars.set(k, temp[j - l]);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        String tree = new SortCharByFreq451().frequencySort("raaeaedere");
        System.out.println(tree);
    }
}
