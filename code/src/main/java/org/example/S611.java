package org.example;

import java.util.*;

public class S611 {
    public static int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int k = i;
            for (int j = i+1; j < nums.length; j++) {
                while (k+1<nums.length && nums[i] + nums[j] > nums[k+1]){
                    k++;
                }
                res += Math.max(k-j,  0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
    }
}
