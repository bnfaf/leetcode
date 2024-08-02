package org.example;

import java.util.ArrayList;
import java.util.List;

public class offer42 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        int end = 0;
        for (int i = 1; i < nums.length; i++ ) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            if (dp[i] > res){
                end = i;
            }
            res = Math.max(dp[i], res);
        }
        List<Integer> paths = new ArrayList<>();
        int target = res, start = end;
        while (target != 0){
            target -= nums[start];
            start -= 1;
        }
        start += 1;
        System.out.println(start + " "  + end);
        return res;
    }

    public static void main(String[] args) {
        offer42 solution = new offer42();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}
