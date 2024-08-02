package org.example;

public class s309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        // 0 持有  1 不持有且冷冻  2 不持有且不冷冻
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]  = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[prices.length-1][1], dp[prices.length-1][2]);
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(new s309().maxProfit(prices));
    }
}
