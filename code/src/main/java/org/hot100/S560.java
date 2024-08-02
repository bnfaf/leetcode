package org.hot100;

import java.util.HashMap;
import java.util.Map;

public class S560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0, 1);
        for (int num : nums){
             if (map.containsKey(pre + num - k)){
                 count += map.get(pre + num - k);
             }
             pre += num;
             map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1, 1};
        System.out.println(new S560().subarraySum(nums, 2));
    }

}
