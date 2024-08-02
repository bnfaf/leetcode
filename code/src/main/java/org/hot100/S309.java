package org.hot100;

public class S309 {
    public int maxProfit(int[] prices) {
        // 0 不持有 可交易 1 不持有 冷冻  2 持有
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][2] = - prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][2] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] - prices[i]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
