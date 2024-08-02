package org.offer;

public class O46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        return dfs(s);
    }
    public int dfs(String s){
        if (s.length() <= 1){
            return s.length();
        }
        int res = dfs(s.substring(1));
        if (Integer.parseInt(s.substring(0, 2)) <= 25 && s.charAt(0) != '0'){
            res += Math.max(dfs(s.substring(2)), 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new O46().translateNum(506));
    }
}
