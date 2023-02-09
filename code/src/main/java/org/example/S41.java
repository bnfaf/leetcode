package org.example;

import java.util.Arrays;

public class S41 {
    public int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] <= 0){
//                nums[i] = n + 1;
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            int num = Math.abs(nums[i]);
//            if (num <= n){
//                nums[num - 1] = - Math.abs(nums[num-1]);
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (nums[i] > 0){
//                return i + 1;
//            }
//        }
//        return n + 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return n + 1;
    }

}
