package org.offer;

public class O63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 0 持有  1 未持有
        dp[0][0] = - prices[0];
        for (int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
        }
        return dp[n-1][1];
    }

    public static void main(String[] args) {
        int[] nums = {7,6,4,3,1};
        System.out.println(new O63().maxProfit(nums));
    }
}
