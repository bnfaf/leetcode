package org.hot100;

import java.util.Arrays;

public class S416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1){
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        Arrays.sort(nums);
        for (int num: nums){
            for (int i = sum; i>=num; i--){
                dp[i] = dp[i-num] | dp[i];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {23,13,11,7,6,5,5};
        System.out.println(new S416().canPartition(nums));
    }
}
