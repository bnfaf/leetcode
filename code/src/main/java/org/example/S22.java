package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S22 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int N;
    ArrayList[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
    public List<String> generateParenthesis(int n) {
        N = n;
        travel(0, 0);
        return res;
    }



    public void travel(int left, int right){
        if (left == N && right == N){
            res.add(sb.toString());
            return;
        }
        if (left < N){
            sb.append("(");
            travel(left+1, right);
            sb.deleteCharAt(left+right);
        }
        if (left > right){
            sb.append(")");
            travel(left, right+1);
            sb.deleteCharAt(left + right);
        }
    }

    public static void main(String[] args) {
        S22 solution = new S22();
        System.out.println(solution.generateParenthesis(4));

    }
}
