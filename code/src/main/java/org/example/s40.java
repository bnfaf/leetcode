package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s40 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backend(candidates, target, 0);
        return res;
    }
    public void backend(int[] candidates, int target, int start){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        int i = start;
        while( i < candidates.length && candidates[i] <= target){
            path.add(candidates[i]);
            backend(candidates, target - candidates[i], i+1);
            path.remove(path.size() - 1);
            while (i+1<candidates.length && candidates[i+1] == candidates[i]){
                i++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        s40 solution = new s40();
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        System.out.println(solution.combinationSum2(candidates, 8));
    }
}
