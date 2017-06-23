package leetcode;

import java.util.LinkedList;

/**
 * Created by mazhi on 2016/9/29.
 */
public class gragh {
    //Surrounded Regions
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1)
            return;
        for (int i = 0; i < board[0].length; i++) {
            fill(board, 0, i);
            fill(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            fill(board, i, 0);
            fill(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void fill(char[][] board, int i, int j) {
        if (board[i][j] != 'O')
            return;
        board[i][j] = '#';
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int code = i * board[0].length + j;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();//返回列表头元素
            int row = code / board[0].length;
            int col = code % board[0].length;
            if (row > 0 && board[row - 1][col] == 'O') {
                queue.offer((row - 1) * board[0].length + col);
                board[row - 1][col] = '#';
            }
            if (row < board.length - 1 && board[row + 1][col] == 'O') {
                queue.offer((row + 1) * board[0].length + col);
                board[row + 1][col] = '#';
            }
            if (col > 0 && board[row][col - 1] == 'O') {
                queue.offer(row * board[0].length + col - 1);
                board[row][col - 1] = '#';
            }
            if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
                queue.offer(row * board[0].length + col + 1);
                board[row][col + 1] = '#';
            }
        }
    }

    //Word Search
    //The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        //用于判断一个点是否已经被走过了
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (word.length() == 1 || search(board, i, j, word.substring(1), visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    boolean search(char[][] board, int i, int j, String word, boolean[][] visited) {
        if (word.length() == 0) {
            return true;
        }
        //四个走向
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int k = 0; k < direction.length; k++) {
            int ii = i + direction[k][0];
            int jj = j + direction[k][1];
            if (ii >= 0 && ii < board.length &&
                    jj >= 0 && jj < board[i].length &&
                    board[ii][jj] == word.charAt(0) &&
                    visited[ii][jj] == false) {
                visited[ii][jj] = true;
                if (word.length() == 1 || search(board, ii, jj, word.substring(1), visited)) {
                    return true;
                }
                visited[ii][jj] = false;
            }
        }
        return false;
    }
}
