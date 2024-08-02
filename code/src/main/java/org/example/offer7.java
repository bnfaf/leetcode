package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer7 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <  nums.length-2; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i>0 && nums[i-1] == nums[i]){
                continue;
            }
            int k = nums.length-1;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] > 0){
                    break;
                }
                if (j > i + 1 && nums[j-1] == nums[j]){
                    continue;
                }
                while (j < k && nums[j] + nums[k] > -nums[i]){
                    k--;
                }
                if (j == k){
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        offer7 solution = new offer7();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));
    }
}
