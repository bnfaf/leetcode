package org.example;

import java.util.HashMap;
import java.util.Map;

public class offer11 {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1){
                counter++;
            }else{
                counter--;
            }
            if (map.containsKey(counter)){
                int preIndex = map.get(counter);
                maxLength = Math.max(maxLength, i-preIndex);
            }else{
                map.put(counter, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        offer11 solution = new offer11();
        int[] nums = {0, 1, 1, 1, 0};
        System.out.println(solution.findMaxLength(nums));
    }
}
