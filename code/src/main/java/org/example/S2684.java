package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S2684 {
    int moves = 0;
    int[][] steps;
    public int maxMoves(int[][] grid) {
        steps = new int[grid.length][grid[0].length];
        for(int i = 0; i< grid.length; i++){
            Moves(grid, i, 0);
            if (steps[i][0] > moves){
                moves = steps[i][0];
            }
        }
        return moves;
    }
    public int Moves(int[][] grid, int i, int j){
        if (steps[i][j] != 0){
            return steps[i][j];
        }
        int maxvalue = 0;
        if (check(grid, i-1, j+1) && grid[i-1][j+1]>grid[i][j]){
            maxvalue = Math.max(maxvalue, Moves(grid, i-1, j+1));
        }
        if (check(grid, i, j+1) && grid[i][j+1] >grid[i][j]){
            maxvalue = Math.max(maxvalue, Moves(grid, i, j+1));
        }
        if (check(grid, i+1, j+1) && grid[i+1][j+1] >grid[i][j]){
            maxvalue = Math.max(maxvalue, Moves(grid, i+1, j+1));
        }
        steps[i][j] = maxvalue;
        return maxvalue+1;
    }
    public boolean check(int[][] grid, int i, int j){
        return i < grid.length && i >= 0 && j < grid[0].length && j >= 0;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {3, 2, 4},
                {2, 1, 9},
                {1, 1, 7}};
        System.out.println(new S2684().maxMoves(nums));
    }
}
