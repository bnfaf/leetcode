package org.example;

import java.util.Arrays;

public class s2460 {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++){
            nums[i] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(Arrays.toString(new s2460().applyOperations(nums)));
    }
}
