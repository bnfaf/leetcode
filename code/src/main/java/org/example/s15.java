package org.example;

import java.util.*;

public class s15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return res;
            }
            if (i > 0 & nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right -= 1;
                } else if (sum < 0) {
                    left += 1;
                }else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]){
                        right -= 1;
                    }
                    while (right > left && nums[left] == nums[left +1]){
                        left += 1;
                    }
                    left += 1;
                    right -= 1;
                }
            }
        }
        return res;
    }
}
