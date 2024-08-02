package org.hot100;

public class S647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = n;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n-2; i>=0; i--){
            for (int j = i+1; j<n;j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i == 1){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                count += dp[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new S647().countSubstrings("abc"));
    }
}
