package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

public class s96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++){
                dp[i] += (dp[i-j]*dp[j-1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        s96 solution = new s96();
        System.out.println(solution.numTrees(3));
    }
}
