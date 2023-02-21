package org.example;

public class s55 {
    public boolean canJump(int[] nums) {
        int count = nums[0];
        int i = 1;
        while (count>= i && count < nums.length-1){
            count = Math.max(count, i+nums[i]);
            i++;
        }
        return count == nums.length-1;
    }

    public static void main(String[] args) {
        s55 solution = new s55();
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(solution.canJump(nums));
    }
}
