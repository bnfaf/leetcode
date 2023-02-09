package org.example;

import java.util.ArrayList;
import java.util.List;

public class S93 {
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<String>();
        backtrack(tmp, s, "", 0, 0);
        return ans;
    }
    public void build(ArrayList<String> builder,  String s, int index, int t){
        if (t == 5){
            ans.add(String.join(".", builder));
            return;
        }
        int n = s.length() - 1;
        if (s.charAt(index) == '0'){
            if (4-t <= n - index && n - index <= 3 * (4-t)){
                builder.add(s.substring(index, index+1));
                build(builder, s, index+1, t+1);
                builder.remove(t-1);
            }
            return;
        }
        for (int i = index; i < index + 3; i++) {
            if (4-t <= n - i && n - i <= 3 * (4-t) && Integer.parseInt(s.substring(index, Math.min(i+1, n+1))) <= 255){
                builder.add(s.substring(index, i+1));
                build(builder, s, i+1, t+1);
                builder.remove(t-1);
            }
        }
    }


    public void backtrack(List<String> tmp, String s, String str, int p, int idx){
        if (p==4 && idx == s.length()){
            ans.add(str);
            return;
        }
        if ((4-p) * 3 < s.length() - idx) {
            return;
        }
        int sum = 0;
        for (int i = idx; i <s.length(); i++ ) {
            if (s.charAt(idx) == '0' && i > idx){
                break;
            }
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum > 0 && sum <= 255){
                backtrack(tmp, s, str + sum + (p == 3 ? "" : "."), p+1, i+1);
            }else {
                return;
            }
        }

    }
    public static void main(String[] args) {
        S93 solution = new S93();
        String s = "25525511135";
        List<String> ans = solution.restoreIpAddresses(s);
        ans.forEach(System.out::println);
    }
}
