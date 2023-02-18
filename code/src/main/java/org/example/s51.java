package org.example;

import java.util.ArrayList;
import java.util.List;

public class s51 {
    List<List<String>> res = new ArrayList<>();
    List<StringBuilder> path = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            path.add(new StringBuilder(sb));
        }
        backend(0, n);
        return res;

    }
    public void backend(int start, int n){
        if (start >= n){
            List<String> copy = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                copy.add(path.get(i).toString());
            }
            res.add(copy);
            return;
        }

        for (int j = 0; j < n; j++) {
            boolean flag = false;
            for (int k = start; k >= 0; k--) {
                if (path.get(k).charAt(j) == 'Q') {
                    flag = true;
                    break;
                }
            }
            if (flag){
                continue;
            }
            for (int a = start, b = j;a >= 0 && b >= 0; a--, b--){
                if (path.get(a).charAt(b) == 'Q') {
                    flag = true;
                    break;
                }
            }
            if (flag){
                continue;
            }
            for (int a = start, b = j; a >= 0 && b < n; a--, b++) {
                if (path.get(a).charAt(b) == 'Q'){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                path.get(start).setCharAt(j, 'Q');
                backend(start+1, n);
                path.get(start).setCharAt(j, '.');
            }
        }
    }


    public static void main(String[] args) {
        s51 solution = new s51();
        System.out.println(solution.solveNQueens(4));
    }
}
