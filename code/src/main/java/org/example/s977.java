package org.example;

public class s977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length-1, index = nums.length-1;
        while (index >=0){
            if (nums[left] * nums[left] >= nums[right] * nums[right]){
                res[index--] = nums[left] * nums[left];
                left++;
            }else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
