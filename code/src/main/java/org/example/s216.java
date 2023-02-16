package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class s216 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backend(k, n, 1);
        return res;
    }
    public void backend(int k, int n, int start){
        if (k == 0){
            if (n == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= Math.min(n/k, 9); i++) {
            path.add(i);
            backend(k-1, n-i, i+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        s216 solution = new s216();
        System.out.println(solution.combinationSum3(2, 18));
    }
}
