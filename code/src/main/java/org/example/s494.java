package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.Arrays;

public class s494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1){
            return 0;
        }
        int size = (sum + target) / 2;
        int[] dp = new int[size+1];
        dp[0] = 1;
        for (int num:nums){
            for (int j = size; j >= num; j--){
                dp[j] += dp[j-num];
            }
        }
        return dp[size];

    }

    public static void main(String[] args) {
        s494 solution = new s494();
        System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
