package org.hot100;

import java.util.Arrays;

public class S34 {
    public int[] searchRange(int[] nums, int target) {
        int Left = -1, Right = -1;
        if (nums.length == 0){
            return new int[]{Left, Right};
        }
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                Left = searchLeft(nums, left, mid, target);
                Right = searchRight(nums, mid, right, target);
                return new int[]{Left, Right};
            } else if (nums[mid] < target) {
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        return new int[]{Left, Right};
    }
    public int searchLeft(int[] nums, int left, int right, int target){
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
    public int searchRight(int[] nums, int left, int right, int target){
        while (left + 1 < right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                left = mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            }
        }
        return nums[right] == target?right:left;
    }



    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(Arrays.toString(new S34().searchRange(nums, 2)));
    }
}
