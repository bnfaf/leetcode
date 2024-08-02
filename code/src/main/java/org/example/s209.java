package org.example;

public class s209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, len = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right++];
            if (sum >= target){
                while (sum >= target){
                    sum -= nums[left++];
                }
                len = Math.min(len, right - left+1);
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,4};
        s209 solution = new s209();
        System.out.println(solution.minSubArrayLen(4, nums));
    }
}
