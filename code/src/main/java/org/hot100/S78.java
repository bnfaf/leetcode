package org.hot100;

import java.util.ArrayList;
import java.util.List;

public class S78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backend(nums, 0, path);
        return res;
    }
    public void backend(int[] nums, int index, List<Integer> path){
        if (index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        backend(nums, index+1, path);
        path.add(nums[index]);
        backend(nums, index+1, path);
        path.remove(path.size()-1);
    }
}
