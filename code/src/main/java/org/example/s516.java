package org.example;

public class s516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len+1][len+1];
        for (int i = len-1;i>=0;i--){
            dp[i][i] = 1;
            for (int j = i+1; j < len;j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], Math.max(dp[i][j], dp[i+1][j]));
                }
            }
        }
        return dp[0][len-1];
    }
}
