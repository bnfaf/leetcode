package org.example;

import java.util.Arrays;

public class s2708 {
    public static long maxStrength(int[] nums) {
//        long[][] dp = new long[nums.length][2]; // 0 最大值， 1 最小值
//        // 因为有负值 所以需要计算最大值和最小值
//        dp[0][0] = dp[0][1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i][0] = Math.max(Math.max(dp[i-1][0], nums[i]), Math.max(dp[i-1][0]*nums[i], dp[i-1][1]*nums[i]));
//            dp[i][1] = Math.min(Math.min(dp[i-1][1], nums[i]), Math.min(dp[i-1][0]*nums[i], dp[i-1][1]*nums[i]));
//        }
//        return dp[nums.length-1][0];
        long mx = nums[0], mn = nums[0];
        for (int i = 1; i < nums.length; i++){
            long tmp = mx;
            mx = Math.max(Math.max(mx, nums[i]), Math.max(mx*nums[i], mn*nums[i]));
            mn = Math.min(Math.min(mn, nums[i]), Math.min(tmp*nums[i], mn*nums[i]));
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] nums = {3,-1,-5,2,5,-9};
        System.out.println(maxStrength(nums));
    }
}
