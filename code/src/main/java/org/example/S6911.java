package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class S6911 {
    public static long continuousSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        long ans = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (Math.abs(Collections.max(map.keySet()) - Collections.min(map.keySet())) > 2) {
                int y = nums[left];
                map.put(y, map.get(y) - 1);
                if (map.get(y) == 0){
                    map.remove(y);
                }
                left++;
            }
            ans += i-left+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 4};
        System.out.println(continuousSubarrays(nums));
    }
}
