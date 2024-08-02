package org.hot100;

import java.util.Arrays;

public class S494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int count = sum + target;
        if ((count &1) ==1 || count < 0){
            return 0;
        }
        count /= 2;
        int[] dp = new int[count+1];
        dp[0] = 1;
        for(int num: nums){
            for (int i = count; i>=num; i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[count];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(new S494().findTargetSumWays(nums, target));
    }
}
