package org.example;

public class s36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[board.length][board.length];
        int[][] col = new int[board.length][board.length];
        int[][] partile = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (row[i][board[i][j]-'0']==1){
                        return false;
                    }
                    if (col[j][board[i][j] - '0']==1){
                        return false;
                    }
                    if (partile[i/3+j/3][board[i][j] - '0']==1){
                        return false;
                    }
                    row[i][board[i][j]-'0'] =  1;
                    col[j][board[i][j] - '0'] = 1;
                    partile[i/3+j/3][board[i][j] - '0'] = 1;
                }
            }
        }
        return true;
    }
}
