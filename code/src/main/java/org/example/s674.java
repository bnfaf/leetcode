package org.example;

import java.util.Arrays;

public class s674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1]+1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        s674 solution = new s674();
        int[] nums = new int[]{1,3,5,4,2,3,4,5};
        System.out.println(solution.findLengthOfLCIS(nums));
    }
}
