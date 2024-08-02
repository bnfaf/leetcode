package org.example;

public class offer3 {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if (n == 0){
            return dp;
        }
        int pre = 1;
        dp[1] = 1;
        if (n == 1){
            return dp;
        }
        for (int i = 2; i <= n; i++) {
            if (i == 2 * pre){
                dp[i] = 1;
                pre = i;
            }else{
                dp[i] = dp[pre] + dp[i-pre];
            }
        }
        return dp;

    }
}
