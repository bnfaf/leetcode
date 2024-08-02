package org.example;

import java.util.Arrays;

public class offer4 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i=i+3) {
            if (i+1<nums.length && nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
