package org.example;

import java.util.ArrayList;
import java.util.List;

public class s77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backend(n, k, 1, new ArrayList<>());
        return res;
    }
    public void backend(int n, int k, int start, List<Integer> path){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <=n - (k - path.size()) + 1; i++) {
            path.add(i);
            backend(n, k, i+1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        s77 solution = new s77();
        System.out.println(solution.combine(4, 2));
    }
}
