package org.hot100;

public class S200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j){
        if (i<0||i>=grid.length || j <0 || j >= grid[0].length){
            return;
        }
        if (grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        int[] direction = {-1, 0, 1, 0, -1};
        for(int k = 0; k < 4; k++){
            dfs(grid, i+direction[k], j+direction[k+1]);
        }
    }
}
