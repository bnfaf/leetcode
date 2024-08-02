package org.example;

import java.util.Arrays;

public class s179 {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                flag = true;
            }
            arr[i] = String.valueOf(nums[i]);
        }
        if (!flag){
            return "0";
        }
        Arrays.sort(arr, (a, b) ->{
            return (b+a).compareTo(a+b);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        s179 solution = new s179();
    }
}
