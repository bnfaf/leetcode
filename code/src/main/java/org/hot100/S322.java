package org.hot100;

import java.util.Arrays;

public class S322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for(int coin: coins){
                if (i>=coin){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE/2?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new S322().coinChange(coins, 3));
    }
}
