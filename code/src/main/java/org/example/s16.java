package org.example;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Arrays;

public class s16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int a = nums[i];
            int left = i+1, right = nums.length - 1;
            while (left < right){
                int sum = a + nums[left] + nums[right];
                if (sum > target){
                    right--;
                }else if (sum < target){
                    left++;
                }else{
                    res = target;
                    return res;
                }
                if (Math.abs(target - sum) < Math.abs(target - res)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
