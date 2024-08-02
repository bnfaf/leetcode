package org.example;

import java.util.*;

public class offer10 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++){
            pre += nums[i];
            if (map.containsKey(pre-k)){
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        offer10 solution = new offer10();
        int[] nums = {1, 1, 1};
        System.out.println(solution.subarraySum(nums, 2));
    }
}
