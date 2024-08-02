package org.example;

public class s746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,100,1,1,1,100,1,1,100,1};
        s746 solution = new s746();
        System.out.println(solution.minCostClimbingStairs(nums));
    }
}
