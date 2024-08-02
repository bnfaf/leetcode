package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            if ((long)nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target){
                continue;
            }
            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if ((long)nums[i] + nums[j] + nums[n-1] + nums[n-2] < target){
                    continue;
                }
                int left = j+1, right = n-1;
                long sum;
                while (left < right){
                    sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target){
                        left++;
                    } else if (sum > target) {
                        right--;
                    }else {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        while (left < right && nums[left+1] == nums[left]){
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {
                1000000000,1000000000,1000000000,1000000000
        };
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }
}
