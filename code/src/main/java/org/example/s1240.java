package org.example;

import java.util.Arrays;

public class s1240 {

    public static int tilingRectangle(int n, int m) {
        int k = Math.min(n, m);
        int[] nums = new int[n * m +1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for(int p = 1; p*p<=i && p <=k ;p++){
                nums[i] = Math.min(nums[i], nums[i - p * p ] + 1);
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(tilingRectangle(5, 8));
    }
}
