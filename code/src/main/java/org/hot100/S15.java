package org.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (i>0&&nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1, right = nums.length-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                } else if (sum < 0) {
                    left++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left+1<nums.length && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                    while (right-1 > 0 && nums[right-1] == nums[right]){
                        right--;
                    }
                    right--;
                }
            }
        }
        return res;
    }
}
