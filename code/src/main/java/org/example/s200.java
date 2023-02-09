package org.example;

/**
 * @author Administrator
 */
public class s200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    travel(grid, i, j);
                }
            }
        }
        return res;
    }
    public boolean inArea(char[][] grid, int i, int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[i].length;
    }
    public void travel(char[][] grid, int i, int j){
        if ( !inArea(grid, i, j) || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        travel(grid, i+1, j);
        travel(grid, i, j+1);
        travel(grid, i-1, j);
        travel(grid, i, j-1);
    }
}
