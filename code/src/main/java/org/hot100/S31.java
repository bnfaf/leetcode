package org.hot100;

public class S31 {
    public void nextPermutation(int[] nums) {
        // nums  升序 降序 升序 降序
        if (nums.length <= 1){
            return;
        }
        int left = nums.length-2, right = nums.length-1, n = nums.length-1;
        while (left >=0 && nums[left] >= nums[right]){
            left--;
            right--;
        }
        if (left==-1){
            reverse(nums, 0);
            return;
        }
        right = n;
        while (nums[left] >= nums[right]){
            right--;
        }
        swap(nums, left, right);
        reverse(nums, left+1);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    public void reverse(int[] nums, int start){
        int n = nums.length-1;
        while (start < n){
            swap(nums, start++, n--);
        }
    }

    public static void main(String[] args) {


    }
}
