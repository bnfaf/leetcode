package org.example;

public class S334 {
    public static boolean increasingTriplet(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (second < nums[i]){
                return true;
            }
            if (nums[i] > first){
                second = nums[i];
            } else  {
                first = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }
}
