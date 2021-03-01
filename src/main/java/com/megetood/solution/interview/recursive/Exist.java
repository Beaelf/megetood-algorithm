package com.megetood.solution.interview.recursive;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/22 18:54
 */
public class Exist {
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(searchWord(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        if (index == word.length() - 1) {
            return word.charAt(index) == board[startX][startY];
        }

        if (word.charAt(index) == board[startX][startY]) {
            visited[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY]
                && searchWord(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean res = new Exist().exist(board, "SEE");
        System.out.println(res);
    }
}
