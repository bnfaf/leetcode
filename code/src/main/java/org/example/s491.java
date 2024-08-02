package org.example;

import java.util.*;

public class s491 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backend(nums, 0);
        return res;
    }
    public void backend(int[] nums, int start){
        if (path.size() >= 2){
            res.add(new ArrayList<>(path));
        }
        if (start == nums.length){
            return;
        }
        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size()-1)){
                continue;
            }
            if (used[nums[i]+100] == 1){
                continue;
            }
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[nums[i]+100] = 1;
            backend(nums, i+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Object[][] nums = new Object[3][2];
        nums[0] = new Object[]{"smith", 67};
        nums[1] = new Object[] {"jack", 96};
        nums[2] = new Object[] {"Tom", 70};
        Arrays.sort(nums, (a, b)->Integer.compare((Integer) a[1], (Integer)b[1]));
        System.out.println(Arrays.deepToString(nums));
    }
}
