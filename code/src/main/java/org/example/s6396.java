package org.example;

import java.util.Arrays;

public class s6396 {
    private static int MOD = (int) (1e9 + 7);
    private int minSum, maxSum;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.minSum = min_sum;
        this.maxSum = max_sum;
        int ans = count(num2) - count(num1) + MOD;
        int sum = 0;
        for (char c : num1.toCharArray()){
            sum += c - '0';
        }
        if (minSum <= sum && sum <= maxSum){
            ans++;
        }
        return ans % MOD;
    }
    public int count(String s){
        char[] chars = s.toCharArray();
        int n = s.length();
        int[][] memo = new int[n][Math.max(9 * n, maxSum) + 1];
        for (int i = 0; i < n; i ++){
            Arrays.fill(memo[i], -1);
        }
        return f(chars, memo, 0, 0, true);
    }

    public int f(char[] s, int[][] memo, int i, int sum, boolean isLimit){
        if (sum > maxSum){
            return 0;
        }
        if (i == s.length){
            return sum >= this.minSum ? 1 : 0;
        }
        if (!isLimit && memo[i][sum] != -1){
            return memo[i][sum];
        }
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; d++){
            res = (res + f(s, memo, i+1, sum+d, isLimit && d == up))% MOD;
        }
        if (!isLimit){
            memo[i][sum] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new s6396().count("1", "12", 1, 8));
    }
}
