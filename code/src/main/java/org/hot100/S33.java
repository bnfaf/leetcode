package org.hot100;

public class S33 {
    public static int search(int[] nums, int target) {
        int n = nums.length, left = 0, right = n-1;
        while (left + 1 < right){
            int mid = (left + right) / 2;
            if (nums[left]<=nums[mid]){
                if (nums[left] <= target && nums[mid] >= target){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] < nums[right]){
                if (nums[mid] <= target && nums[right] >= target){
                    left = mid;
                }else{
                    right = mid-1;
                }
            }
        }
        return nums[left] == target ? left:nums[right] == target ? right:-1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
