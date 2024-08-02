package org.hot100;

import java.util.HashMap;
import java.util.Map;

public class S1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey((long)target - nums[i])){
                return new int[]{map.get((long)target - nums[i]), i};
            }
            map.put((long)nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
