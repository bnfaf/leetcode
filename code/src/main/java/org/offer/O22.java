package org.offer;

public class O22 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i< m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == word.charAt(0)  & dfs(board, word, 0, visit, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index, boolean[][] visit, int i, int j){
        if (index == word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j]){
            return false;
        }
        if (board[i][j] != word.charAt(index)){
            return false;
        }
        visit[i][j] = true;
        int[] directions = {-1, 0, 1, 0, -1};
        for(int k = 0; k < 4; k++){
            int newI = i + directions[k], newJ = j + directions[k+1];
            if (dfs(board, word, index+1, visit, newI, newJ)){
                return true;
            }
        }
        visit[i][j] = false;
        return false;
    }
}
