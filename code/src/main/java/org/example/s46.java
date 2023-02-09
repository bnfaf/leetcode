package org.example;

import java.util.*;

/**
 * @author Administrator
 */
public class s46 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, temp);
        return res;
    }

    public void dfs(int[] nums, List<Integer> ans){
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int num: nums){
            if (!ans.contains(num)) {
                ans.add(num);
                dfs(nums, ans);
                ans.remove(Integer.valueOf(num));
            }
        }
    }
}
