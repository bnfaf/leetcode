package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class s152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0] * nums[i], Math.max(dp[i-1][1] * nums[i], nums[i]));
            dp[i][1] = Math.min(dp[i-1][1] * nums[i], Math.min(dp[i-1][0] * nums[i], nums[i]));
            res = Math.max(res, dp[i][0]);
        }
        List<Integer> path = new ArrayList<>();
        int index = dp.length-1;
        int target = res;
        while (dp[index][0] != res){
            index--;
        }
        while (index>=0 && target != 1){
            path.add(index);
            if (nums[index] == 0){
                index--;
                continue;
            }
            target /= nums[index];
            index--;
        }
        Collections.reverse(path);
        System.out.println(path);
        return res;
    }

    public static void main(String[] args) {
        s152 solution = new s152();
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(solution.maxProduct(nums));
    }
}
