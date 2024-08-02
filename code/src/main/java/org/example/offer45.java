package org.example;

import java.util.Arrays;

public class offer45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) ->{
            if ((a+b).compareTo(b+a) > 0){
                return 1;
            }else if (a.equals(b)){
                return 0;
            }else{
                return -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {10, 2};
        offer45 solution = new offer45();
        System.out.println(solution.minNumber(nums));
    }
}
