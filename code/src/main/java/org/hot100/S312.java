package org.hot100;

public class S312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        int[] val = new int[n+2];
        val[0] = val[n+1] = 1;
        System.arraycopy(nums, 0, val, 1, n);
        for (int i = n-1; i>= 0; i--){
            for (int j = i+2; j <= n+1; j++){
                for (int k = i+1; k < j; k++){
                    int sum = val[i] * val[k] * val[j] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n+1];
    }
}
