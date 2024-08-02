package org.example;

import com.sun.org.apache.xerces.internal.impl.xs.util.XIntPool;

import java.util.Arrays;

public class s130 {
    public void solve(char[][] board) {
        int[][] grad = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length-1 || j == board[i].length-1)) {
                    dfs(board, grad,   i, j);
                    grad[i][j] = 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(grad));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (grad[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public boolean isValid(char[][] board, int i, int j){
        if(i<0 || j<0 || i>= board.length||j >= board[0].length){
            return false;
        }
        return true;
    }
    public void dfs(char[][] board, int[][] grad,  int i, int j){
        if (!isValid(board, i, j) || board[i][j] == 'X' || grad[i][j] == 1){
            return;
        }
        grad[i][j] = 1;
        dfs(board, grad, i+1, j);
        dfs(board, grad, i-1, j);
        dfs(board, grad, i, j-1);
        dfs(board, grad, i, j+1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
        };
        s130 solution = new s130();
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
