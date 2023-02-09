package org.example;

import java.util.ArrayList;
import java.util.List;

public class S22 {
    List<String> res = new ArrayList<>();
    int N;
    public List<String> generateParenthesis(int n) {
        N = n;
        ArrayList<String> tmp = new ArrayList<>();
        travel(tmp, 0, 0);
        return res;
    }
    public void travel(ArrayList<String> tmp, int left, int right){
        if (left == N && right == N){
            String path = String.join("", tmp);
            res.add(path);
            return;
        }
        if (left < N){
            tmp.add("(");
            travel(tmp, left+1, right);
            tmp.remove(tmp.size() - 1);
        }
        if (left > right){
            tmp.add(")");
            travel(tmp, left, right+1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        S22 solution = new S22();
        System.out.println(solution.generateParenthesis(3));

    }
}
