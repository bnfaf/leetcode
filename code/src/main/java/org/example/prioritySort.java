package org.example;

import java.util.Arrays;

public class prioritySort {
    int length;
    public int[] sortArray(int[] nums) {
        length = nums.length;
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            length--;
            heaify(nums, 0);
        }
        return nums;
    }
    public void buildMaxHeap(int[] nums){
        for (int i = nums.length/2-1;i>=0;i--){
            heaify(nums, i);
        }
    }
    public void heaify(int[] nums, int index){
        int left = index*2+1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < length && nums[left] > nums[largest]){
            largest = left;
        }
        if (right < length && nums[right] > nums[largest]){
            largest = right;
        }
        if (largest!=index){
            swap(nums, largest, index);
            heaify(nums, largest);
        }

    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {-4,0,7,4,9,-5,-1,0,-7,-1};
        prioritySort solution = new prioritySort();
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }

}
