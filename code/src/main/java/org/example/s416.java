package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
import com.sun.org.apache.xerces.internal.impl.xs.util.XIntPool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class s416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1){
            return false;
        }
        // weight 为 nums,value也是nums[i]
        int[] dp = new int[sum/2+1];
        for (int i = 0; i<nums.length; i++){
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[sum/2] == sum/2;
    }

    public static void main(String[] args) {
        s416 solution = new s416();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(solution.canPartition(nums));
    }
}
