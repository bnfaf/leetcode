package org.example;


import org.openjdk.jol.vm.VM;

import java.lang.reflect.Field;
import java.util.Arrays;

public class s279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i*i <= n; i++) {
            dp[i*i] = 1;
            for (int j = i*i; j <=n;j++){
                dp[j] = Math.min(dp[j], dp[j-i*i]+dp[i*i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new s279().numSquares(12));
    }
}
