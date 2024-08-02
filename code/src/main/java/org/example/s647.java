package org.example;

import java.util.Arrays;

public class s647 {
    int[][] dp;
    public int countSubstrings(String s) {
        int len = s.length(), ans = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++){
            for (int i = 0; i <= j; i++){
                if (s.charAt(i) == s.charAt(j)){
                    if (j-i < 3){
                        dp[i][j] = true;
                        ans++;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                        if (dp[i][j]){
                            ans++;
                        }
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return ans;
    }

}
