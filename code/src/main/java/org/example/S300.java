package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class S300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int value = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            value = Math.max(value, dp[i]);
        }
        return value;
    }

    public static void main(String[] args) {
        S300 solution = new S300();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
