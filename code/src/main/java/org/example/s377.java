package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class s377 {
    public int combinationSum4(int[] nums, int target) {
//        Arrays.sort(nums);
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int j = 0; j < nums.length; j++){
                if (i >= nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        s377 solution = new s377();
        int[] nums = new int[]{3, 1, 2, 4};
        System.out.println(solution.combinationSum4(nums, 4));
    }
}
