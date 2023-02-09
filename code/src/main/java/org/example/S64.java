package org.example;

import java.util.*;

public class S64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 从左边来是0， 上面来是1, 存放地址
        int[][] path = new int[m][n];

        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
            path[0][i] = 0;
        }
        for (int j = 1;j < m; j++){
            grid[j][0] += grid[j-1][0];
            path[j][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                path[i][j] = grid[i-1][j] < grid[i][j-1]?1:0;
            }
        }
        int i = m-1, j = n - 1;
        LinkedList<String> stack = new LinkedList<>();
        while (i!=0 || j != 0){
            stack.addFirst("(" + i + ","+ j + ")");
            if (path[i][j] == 1){
                i-= 1;
            }else {
                j-=1;
            }
        }
        stack.addFirst("(" + i + ","+ j + ")");
        System.out.println(stack);
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        S64 solution = new S64();
        int[][] grid = new int[2][3];
        grid[0] = new int[]{1, 2, 3};
        grid[1] = new int[]{4, 5, 6};
        System.out.println(solution.minPathSum(grid));
    }
}
