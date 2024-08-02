package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.Arrays;

public class s213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int left = robs(Arrays.copyOfRange(nums, 1, nums.length));
        int right = robs(Arrays.copyOfRange(nums, 0, nums.length-1));
        return Math.max(left, right);
    }
    public int robs(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        s213 solution = new s213();
        int[] nums = new int[]{1};
        System.out.println(solution.rob(nums));
    }
}
