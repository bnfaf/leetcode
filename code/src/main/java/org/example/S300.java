package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class S300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        S300 solution = new S300();
        int[] nums = {0,1,0,3,2,3};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
