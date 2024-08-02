package org.example;

import java.util.Arrays;

public class offer12 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == 2 * pre){
                return i;
            }
            pre += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        offer12 solution = new offer12();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(solution.pivotIndex(nums));
    }
}
