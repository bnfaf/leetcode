package org.example;

import java.util.ArrayList;
import java.util.List;

public class s78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backend(nums, 0);
        return res;
    }
    public void backend(int[] nums, int start){
        if (start > nums.length){
            return;
        }
        if (res.isEmpty()){
            res.add(new ArrayList<>());
        }
        int length = res.size();
        for(int i = 0; i < length; i++){
            List<Integer> temp = new ArrayList<>(res.get(i));
            temp.add(nums[start]);
            res.add(temp);
        }
        backend(nums, start+1);
    }
}
