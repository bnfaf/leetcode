package org.example;

public class s376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        int curDiff = 0, preDiff = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i-1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)){
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        s376 solution = new s376();
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(solution.wiggleMaxLength(nums));
    }
}
