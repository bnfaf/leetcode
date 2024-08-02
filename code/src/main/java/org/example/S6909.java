package org.example;

import java.util.ArrayList;
import java.util.List;

public class S6909 {
    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0, i = 0, n = nums.length;
        while ( i < n){
            if (nums[i] % 2 != 0 || nums[i] > threshold ){
                i+=1;
            }else{
                int i0 = i;
                i+=1;
                while (i<n && nums[i] <= threshold && nums[i] %2 != nums[i-1] %2){
                    i+=1;
                }
                ans = Math.max(ans, i - i0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(longestAlternatingSubarray(nums, 18));
    }
}
