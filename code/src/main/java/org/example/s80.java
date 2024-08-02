package org.example;

public class s80 {
    public int removeDuplicates(int[] nums) {
        int point = 0, i = 0;
        while (i < nums.length){
            if (i+1< nums.length && nums[i+1] == nums[i]){
                nums[point++] = nums[i++];
                nums[point++] = nums[i++];
            }else{
                nums[point++] = nums[i++];
            }

            while (i < nums.length &&nums[i] == nums[i-1]){
                i++;
            }
        }
        return point;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        s80 solution = new s80();
        System.out.println(solution.removeDuplicates(nums));
    }
}
