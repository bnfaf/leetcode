package org.example;

import java.util.Arrays;
import java.util.jar.Pack200;

public class s518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin: coins){
            for (int i = coin; i <=amount; i++ ) {
                dp[i] += dp[i-coin];
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        s518 solution = new s518();
        System.out.println(solution.change(5, coins));
    }
}
