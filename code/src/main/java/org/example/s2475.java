package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class s2475 {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                for (int k = j+1; k < list.size(); k++) {
                    res += list.get(i) * list.get(j) * list.get(k);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,2,4,3};
        System.out.println(new s2475().unequalTriplets(nums));
    }
}
