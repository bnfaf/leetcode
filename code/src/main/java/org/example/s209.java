package org.example;

public class s209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, length = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right];
            if (sum >= target){
                while (sum > target){
                    length = right - left + 1 < length ? right - left + 1 : length;
                    sum-=nums[left];
                    left++;
                }
            }
        }
        return length == Integer.MAX_VALUE ? -1 : length;
    }
}
