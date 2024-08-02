package org.hot100;

import java.util.ArrayList;
import java.util.List;

public class S46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        bachend(temp, nums, visit);
        return res;
    }
    public void bachend(List<Integer> temp, int[] nums, boolean[] visit){
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!visit[i]){
                visit[i] = true;
                temp.add(nums[i]);
                bachend(temp, nums, visit);
                visit[i] = false;
                temp.remove(temp.size()-1);
            }
        }

    }
}
