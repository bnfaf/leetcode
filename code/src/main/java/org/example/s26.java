package org.example;

import java.util.Arrays;

public class s26 {
    public int removeDuplicates(int[] nums) {
        int point = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!= nums[i-1]){
                nums[point++] = nums[i];
            }
        }
        return point;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        s26 solution = new s26();
        System.out.println(solution.removeDuplicates(nums));
    }
}
