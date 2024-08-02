package org.example;

import java.util.Arrays;

public class s695 {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    int area = travel(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public boolean isValid(int[][] grid, int i, int j){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }
    public int travel(int[][] grid, int i, int j){
        if (!isValid(grid, i, j) || grid[i][j] != 1){
            return 0;
        }
        grid[i][j]=2;
        return 1+ travel(grid, i+1, j) + travel(grid, i-1, j) + travel(grid, i, j+1) + travel(grid, i, j-1);
    }
}
