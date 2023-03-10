package org.example;

public class S72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n * m == 0) {
            return n * m;
        }
        int [][] DP = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            DP[i][0] = i;
        }
        for (int j = 0; j < m+1; j++) {
            DP[0][j] = j;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int left = DP[i-1][j] + 1;
                int down = DP[i][j-1]+1;
                int left_down = DP[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)){
                    left_down += 1;
                }
                DP[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return DP[n][m];
    }

}
