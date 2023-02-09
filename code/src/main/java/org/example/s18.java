package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (nums[i] > 0 && nums[i] > target){
                return res;
            }
            if (i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if (j > i+1 && nums[j-1] == nums[j]){
                    continue;
                }
                int left = j+1, right = nums.length-1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target){
                        right -= 1;
                    } else if (sum < target) {
                        left += 1;
                    }else {
                        if (!res.contains(Arrays.asList(nums[i], nums[j], nums[left], nums[right]))){
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        }
                        while (left < right && nums[left] == nums[left + 1]){
                            left += 1;
                        }
                        while (left < right && nums[right] == nums[right-1]){
                            right -= 1;
                        }
                        left +=  1;
                        right -= 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {
                1,-2,-5,-4,-3,3,3,5
        };
        int target = -11;
        System.out.println(fourSum(nums, target));
    }
}
