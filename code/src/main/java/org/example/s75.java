package org.example;

public class s75 {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length);
    }
    public void quickSort(int[] nums, int left, int right){
        if (left < right){
            int part = partition(nums, left, right);
            quickSort(nums, left, part);
            quickSort(nums, part+1, right);
        }
    }
    public int partition(int[] nums, int left, int right){
        int privot = nums[right];
        int point = left;
        for (int i = left; i < right; i++){
            if (nums[i] < privot){
                swap(nums, point, i);
                point++;
            }
        }
        swap(nums, point, right);
        return point;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
