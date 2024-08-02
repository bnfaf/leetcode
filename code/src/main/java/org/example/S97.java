package org.example;

public class S97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        if (s1.length() == 0){
            return s2.equals(s3);
        }
        if (s2.length() == 0){
            return s1.equals(s3);
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int j = 1; j<=s2.length(); j++){
            dp[0][j] = dp[0][j-1] & s2.charAt(j-1) == s3.charAt(j-1);
        }
        for(int i = 1; i <= s1.length(); i++){
            dp[i][0] = dp[i-1][0] & s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++) {
                char c = s3.charAt(i + j - 1);
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == c)|| (dp[i][j-1] && s2.charAt(j-1) == c);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
