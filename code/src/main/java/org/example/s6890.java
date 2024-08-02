package org.example;

import java.util.Arrays;

public class s6890 {
    public static int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            res = Math.min(res, nums[i+1] - nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        System.out.println(findValueOfPartition(nums));
    }
}
