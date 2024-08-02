package org.example;

public class s35 {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]){
            return nums.length;
        }
        if (target <= nums[0]){
            return 0;
        }
        int left = 0, right = nums.length-1, mid;
        while (left <= right){
            mid = (left+right) / 2;
            if (nums[mid] > target){
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
