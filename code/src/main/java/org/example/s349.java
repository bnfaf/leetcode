package org.example;

import java.util.*;

public class s349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!arr.contains(nums1[i])){
                arr.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (arr.contains(nums2[i]) && !result.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
