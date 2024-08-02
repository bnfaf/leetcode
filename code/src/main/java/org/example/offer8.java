package org.example;

public class offer8 {
    public int minSubArrayLen(int target, int[] nums) {
          int sum = 0;
          int res = Integer.MAX_VALUE;
          int left = 0, right = 0;
          while (right < nums.length){
              while (right < nums.length &&sum < target){
                  sum += nums[right];
                  right++;
              }
              if (sum >= target){
                  while (sum>=target){
                      sum -= nums[left];
                      left++;

                  }
                  res = Math.min(res, right - left+1);
              }
          }
          return res == Integer.MAX_VALUE ? 0: res;
    }

    public static void main(String[] args) {
        offer8  solution = new offer8();
        int[] nums = {1,2,3,4,5};
        System.out.println(solution.minSubArrayLen(15, nums));
    }
}
