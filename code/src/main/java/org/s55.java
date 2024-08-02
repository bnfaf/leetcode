package org;

public class s55 {
    public boolean canJump(int[] nums) {
        int count = nums[0];
        if (count < 1 && nums.length > 1){
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            count = Math.max(count, i+nums[i]);
            if (count == nums.length-1){
                return true;
            }
            if (count < i+1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        s55 solution = new s55();
        System.out.println(solution.canJump(nums));
    }
}
