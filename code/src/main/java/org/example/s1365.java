package org.example;

import java.awt.image.ImagingOpException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class s1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            if (!map.containsKey(res[i])) {
                map.put(res[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        s1365 solution = new s1365();
        int[] nums = new int[]{8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums)));
    }
}
