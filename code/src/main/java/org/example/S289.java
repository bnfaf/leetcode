package org.example;

public class S289 {
    public void gameOfLife(int[][] board) {
        int[][] origin = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            origin[i] = board[i].clone();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++){
                int count = count(origin, i, j);
                if (origin[i][j] == 1 && count < 2){
                    board[i][j] = 0;
                } else if (origin[i][j] == 1 && count > 3) {
                    board[i][j] = 0;
                } else if (origin[i][j] == 0 && count == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }
    public int count(int[][] board, int i, int j){
        int count = 0;
        for(int left = -1; left <= 1; left++){
            for (int right = -1; right <= 1; right++){
                int newI = i + left, newJ = j + right;
                if (newI >=0 && newI < board.length && newJ >= 0 && newJ < board[0].length && !(newI == i && newJ == j)){
                    if (board[newI][newJ] == 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
