package org.example;

public class s153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        s153 solution = new s153();
        System.out.println(solution.findMin(nums));
    }
}
