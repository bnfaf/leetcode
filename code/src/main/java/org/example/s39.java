package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class s39 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backend(candidates, target, 0);
        return res;
    }
    public void backend(int[] candidates, int target, int start){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            backend(candidates, target-candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
