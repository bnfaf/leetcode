package org.example;

import java.util.*;

public class backToOrigin {
    /**
     * 题目描述： 0-9共10个数构成一个环，从0出发，每次走1步，走 n步回到0共有多少种走法
     */
    public int solve(int n) {
        int length = 10;
        int[][] dp = new int[n + 1][length];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1 + length) % length];
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        backToOrigin solution = new backToOrigin();
        System.out.println(solution.solve(10));
    }
}
