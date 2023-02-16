package org.example;

import java.util.ArrayList;
import java.util.List;

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
        s491 solution = new s491();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        System.out.println(solution.findSubsequences(nums));
    }
}
