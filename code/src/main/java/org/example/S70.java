package org.example;

public class S70 {
    public static int climbStairs(int n) {
        // 完全背包问题 排列
       int[] dp = new int[n+1];
       dp[0] = 1;
       int[] nums = new int[]{1, 2};
       // bagSize在外，石头在内
       for (int i=1;i<=n;i++){
           for (int num: nums){
               if (i >= num){
                   dp[i] += dp[i-num];
               }
           }
       }
       return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
