package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s90 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backend(nums, 0);
        return res;
    }
    public void backend(int[] nums, int start){
        res.add(new ArrayList<>(path));
        if (start == nums.length){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i-1] == nums[i]){
                continue;
            }
            path.add(nums[i]);
            backend(nums, i+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        s90 solution = new s90();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
    }
}
