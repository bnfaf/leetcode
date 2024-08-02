package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class s397 {
    Map<Long, Integer> map = new HashMap<Long, Integer>();
    public int integerReplacement(int n) {
        map.put(1L, 0);
        return dfs(n);
    }
    public int dfs(long n){
        if (map.containsKey(n)){
            return map.get(n);
        }
        int res;
        if ((n&1)==1){
             res = Math.min(dfs(n+1), dfs(n-1))+1;
        }else{
            res = dfs(n/2)+1;
        }
        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(new s397().integerReplacement(n));
    }
}
