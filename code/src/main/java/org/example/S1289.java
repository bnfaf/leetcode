package org.example;

public class S1289 {
    public static int minFallingPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0){
                    dp[i][j] = grid[i][j];
                }else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 0; j< n; j++){
                for (int k = 0; k < n; k++){
                    if (j == k){
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + grid[i][j]);
                }
            }
        }
        for (int j = 0; j < n; j++){
            res= Math.min(res, dp[m-1][j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {-73,61,43,-48,-36},
                {3,30,27,57,10},
                {96,-76,84,59,-15},
                {5,-49,76,31,-7},{97,91,61,-46,67}
        };
        System.out.println(minFallingPathSum(grid));
    }
}
