package org.hot100;

public class S55 {
    public boolean canJump(int[] nums) {
        int count = 0;
        int index  = 0;
        while (index < nums.length){
            count = Math.max(count, nums[index] + index);
            if (count >= index+1){
                index++;
            }else return count >= nums.length - 1;
        }
        return true;
    }
}
