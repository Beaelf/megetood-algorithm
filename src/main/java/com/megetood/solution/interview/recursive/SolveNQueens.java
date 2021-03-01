package com.megetood.solution.interview.recursive;

import com.megetood.structure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/23 19:50
 */
public class SolveNQueens {

    List<List<String>> res;
    boolean[] col;
    boolean[] dial1, dial2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        dial1 = new boolean[2 * n - 1];
        dial2 = new boolean[2 * n - 1];

        List<Integer> row = new ArrayList<>(n);
        putQueen(n, 0, row);

        return res;
    }

    /**
     * 在n皇后中，拜访第index行的皇后位置
     *
     * @param n
     * @param index
     * @param row
     */
    private void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 尝试将第index拜访在第i列
            // 当前列没有皇后，并且两个对角线也没有皇后
            if (!col[i] && !dial1[index + i] && !dial2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dial1[index + i] = true;
                dial2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dial1[index + i] = false;
                dial2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
        return;
    }

    private List<String> generateBoard(int n, List<Integer> row) {
        StringBuilder line = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            line.append('.');
        }
        List<String> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            board.add(line.toString());
        }

        for (int i = 0; i < n; i++) {
            board.set(i, board.get(i).substring(0, row.get(i)) + "Q" + board.get(i).substring(row.get(i) + 1));
        }

        return board;
    }

    public static void main(String[] args) {
        int n = 4;
        StringBuilder line = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            line.append('.');
        }
        List<String> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            board.add(line.toString());
        }
        System.out.println(board.toString());
        for (int i = 0; i < n; i++) {
            board.set(i, board.get(i).substring(0, i) + "Q" + board.get(i).substring(i + 1));
        }
        System.out.println(board.toString());
    }
}
