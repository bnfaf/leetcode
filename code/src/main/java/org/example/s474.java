package org.example;

public class s474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] count = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++){
            for(char c: strs[i].toCharArray()){
                count[i][c-'0'] += 1;
            }
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j>=count[i][0];j--){
                for (int k = n; k>=count[i][1]; k--) {
                    dp[j][k]  = Math.max(dp[j][k], dp[j-count[i][0]][k-count[i][1]]+1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        s474 solution = new s474();
        String[] strs = new String[]{"10","0001","111001","1","0"};
        System.out.println(solution.findMaxForm(strs, 5, 3));
    }
}
