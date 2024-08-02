package org.example;

/**
 * @author 10840
 */
public class s463 {
    public int islandPerimeter(int[][] grid) {
        int len = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    len = travel(grid, i, j);
                }
            }
        }
        return len;
    }
    public boolean isValid(int[][] grid, int i, int j){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }
    public int travel(int[][] grid, int i, int j){
        if (!isValid(grid, i, j) || grid[i][j] == 0){
            return 1;
        }
        if (grid[i][j] == 2){
            return 0;
        }
        grid[i][j]=2;
        return travel(grid, i+1, j) + travel(grid, i-1, j) + travel(grid, i, j+1) + travel(grid, i, j-1);
    }
}
