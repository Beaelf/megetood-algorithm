package com.megetood.solution.nowcoder;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * todo
 *
 * @author Lei Chengdong
 * @date 2020/11/23
 */
public class FindKth {
    public int findKth(int[] a, int n, int K) {
        Queue<Integer> queue = new PriorityQueue<>((c1, c2) -> c2 - c1);
        for (int i = 0; i < n; i++) {
            queue.offer(a[i]);
        }
        int res = -1;
        for (int i = 1; i <= K; i++) {
            res = queue.poll();
        }
        return res;
    }
}

