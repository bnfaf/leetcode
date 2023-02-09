package org.example;

import java.util.HashMap;
import java.util.Map;

public class s454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for (int s : nums1){
            for (int t : nums2){
                if (res.containsKey(s+t)){
                    res.put(s+t, res.get(s+t)+1);
                }else {
                    res.put(s+t, 1);
                }
            }
        }
        int sum = 0;
        for (int s : nums3) {
            for (int t : nums4) {
                if (res.containsKey(-s-t)){
                    sum += res.get(s+t);
                }
            }
        }
        return sum;
    }
}
