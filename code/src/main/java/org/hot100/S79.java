package org.hot100;

public class S79 {
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length-1, n = board[0].length-1;
        boolean[][] visit = new boolean[m+1][n+1];
        for (int i = 0; i <= m; i++){
            for (int j =0; j <=n; j++){
                if (board[i][j] == word.charAt(0)){
                    dfs(board, visit, word, 0, i, j);
                    if (res){
                        break;
                    }
                }
            }
        }
        return res;
    }
    public void dfs(char[][] board, boolean[][] visit, String word, int index, int i, int j){

        if (visit[i][j]||word.charAt(index) != board[i][j]){
            return;
        }
        if (index+1 == word.length()){
            res = true;
            return;
        }
        int[] direction = {-1, 0, 1, 0, -1};
        visit[i][j] = true;
        for(int k = 1; k < direction.length; k++){
            int x = i + direction[k-1], y = j + direction[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
                continue;
            }
            dfs(board, visit, word, index+1, x, y);
        }
        visit[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] c = {
                {'a'}
        };

        System.out.println(new S79().exist(c, "a"));
    }
}
